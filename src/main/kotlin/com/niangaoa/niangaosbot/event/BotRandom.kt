package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.content
import java.util.*

/**
 * 随机生成0~9的数
 * 继承WifeMessage
 * 使用范例:随机生成0,9
 * @author niangaoa
 * @see BotMessage
 * */
class BotRandom : BotMessage() {
    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (mainConfigDataUtils.isGottenSenderInConfig(sender)) {
                    if (message.content.contains("随机生成")) {
                        val buffer = StringBuffer(message.content)
                        buffer.delete(0, 4)
                        buffer.delete(1, 2)
                        val random = Random()
                        val i1 = buffer.toString().toInt() / 10
                        val i2 = buffer.toString().toInt() - ((buffer.toString().toInt() / 10)*10) + 1
                        val r1 = random.nextInt(i1, i2)
                        group.sendMessage(At(sender.id) + "你抽到了$r1~")
                    }
                }
            }
        }
    }

    override fun run() {
        botEventChannel(eventChannel)
    }
}