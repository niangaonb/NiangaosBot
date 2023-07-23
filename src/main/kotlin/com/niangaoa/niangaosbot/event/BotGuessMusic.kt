package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.Audio
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import java.io.File
import java.util.*


class BotGuessMusic : BotMessage() {
    private lateinit var buffer : StringBuffer
    private var test = false
    private var randomInt = -1

    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (message.content == "随机歌曲") {
                    val folder = File("music")
                    val musicList = folder.listFiles()
                    val randomMusic = Random()
                    if (musicList != null) {
                        randomInt = randomMusic.nextInt(0, musicList.size)
                    }
                    val originalResource = musicList?.get(randomInt)
                    val resource = originalResource?.toExternalResource()
                    val audio: Audio = resource.use {
                        group.uploadAudio(resource!!)
                    }
                    group.sendMessage(audio)
                    group.sendMessage("来猜来猜")
                    if (originalResource != null) {
                        buffer = StringBuffer(originalResource.name)
                    }
                    resource?.close()
                    buffer.delete((buffer.length - 4), buffer.length)
                    test = true
                    randomInt = -1
                }
                if (buffer.isNotEmpty() && buffer.toString().contains(message.content) && test) {
                    group.sendMessage("恭喜" + At(sender.id) +"答对啦！就是$buffer~")
                    buffer.delete(0, buffer.length)
                    test = false
                }
            }
        }
    }
}