package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

class BotStudy : BotMessage() {
    private val iDontKnowTheName = HashMap<Long, Boolean>()
    private val target = StringBuffer()

    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                System.err.println("Target: $target")
                if (message.content.contains("监督")) {
                    target.append(message.content)
                    target.delete(0, 3)
                    group.sendMessage("要认真哦~")
                    if (iDontKnowTheName.isEmpty()) {
                        iDontKnowTheName[target.toString().toLong()] = false
                        System.err.println("111")
                    }
                }
                if (sender.id == target.toString().toLong()) {
                    iDontKnowTheName[target.toString().toLong()] = true
                }
                if (iDontKnowTheName[target.toString().toLong()]!!) {
                    group.sendMessage("说了要好好学习的 哼")
                    group.members[target.toString().toLong()]?.mute(3600)
                    System.err.println("1345rsadf")
                    iDontKnowTheName.clear()
                }
            }
        }
    }
}