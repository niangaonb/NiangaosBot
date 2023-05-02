package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import java.util.*

/**
 * 一些普通的小交流(调 情)
 * 继承了WifeMessage
 * @see BotMessage
 * @author niangaoa
 * */
class BotCommunicate : BotMessage() {
    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            //这里判断了组(在AcceptedGroups里设置)
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                var message1 = "null"
                if (message.content.contains("老婆")) {
                    if (message.content.contains("在")) {
                        //这里判断了成员(在AcceptedMembers里设置)
                        if (mainConfigDataUtils.isGottenSenderInConfig(sender)) {
                            val random = Random()
                            when (random.nextInt(1, 3)) {
                                1 -> message1 = "在呢老公，有什么事吗？"
                                2 -> message1 = "老公我在~"
                            }
                            group.sendMessage(message1)
                        } else {
                            group.sendMessage("请问您有什么事情吗")
                        }
                    }
                    if (message.content.contains("透一下")) {
                        //这里判断了成员(在AcceptedMembers里设置)
                        if (mainConfigDataUtils.isGottenSenderInConfig(sender)) {
                            val random = Random()
                            when (random.nextInt(1, 3)) {
                                1 -> message1 = "别吧老公……人家会害羞的"
                                2 -> message1 = "不要嘛！人家生气了"
                            }
                            group.sendMessage(message1)
                        } else {
                            group.sendMessage("唔，免了吧")
                        }
                    }
                }
            }
        }
    }
}
