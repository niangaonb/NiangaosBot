package com.niangaoa.niangaos_bot.message

import com.niangaoa.niangaos_bot.bot.BotMessage
import com.niangaoa.niangaos_bot.bot.IBotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.Audio
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import java.io.File
import java.util.*

/**
 * 随机歌曲类
 * @author niangaoa
 * */
class BotGuessMusic : BotMessage(), IBotMessage {
    private var buffer = StringBuffer()
    private var key = false
    private var randomInt = -1

    override fun botEventChannel(event: EventChannel<Event>) {
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (message.content == "随机歌曲") {
                    //获取歌曲文件名
                    val folder = File("music")
                    val musicList = folder.listFiles()
                    val randomMusic = Random()
                    if (musicList != null) {
                        randomInt = randomMusic.nextInt(0, musicList.size)
                    }
                    //随机歌曲
                    val originalResource = musicList?.get(randomInt)
                    val resource = originalResource?.toExternalResource()
                    //向服务器上传
                    val audio: Audio = resource.use {
                        group.uploadAudio(resource!!.toAutoCloseable())
                    }
                    //发送
                    group.sendMessage(audio)
                    group.sendMessage("来猜来猜")
                    //给buffer发名字，方便后面判断是不是对的名字
                    if (originalResource != null) {
                        buffer = StringBuffer(originalResource.name)
                    }
                    //切除后缀名
                    buffer.delete((buffer.length - 4), buffer.length)
                    key = true
                    //让随机生成的缓存数回到默认
                    randomInt = -1
                }
                if (buffer.isNotEmpty() && buffer.toString().contains(message.content) && key) {
                    group.sendMessage(At(sender.id) + "恭喜" + sender.nick + "答对啦！就是$buffer~")
                    //全部归默认
                    buffer.delete(0, buffer.length)
                    key = false
                }
            }
        }
    }
}