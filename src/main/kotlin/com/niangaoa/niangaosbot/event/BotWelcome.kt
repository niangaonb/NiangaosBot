package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.MemberJoinEvent

class BotWelcome : BotMessage() {
    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<MemberJoinEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                group.sendMessage("欢迎新人~ 欢迎来到年糕的编程/编曲群")
            }
        }
    }
}