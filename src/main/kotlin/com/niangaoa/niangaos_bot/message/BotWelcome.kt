package com.niangaoa.niangaos_bot.message

import com.niangaoa.niangaos_bot.bot.BotMessage
import com.niangaoa.niangaos_bot.bot.IBotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.MemberJoinEvent

class BotWelcome : BotMessage(), IBotMessage {
    override fun botEventChannel(event: EventChannel<Event>) {
        event.subscribeAlways<MemberJoinEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                group.sendMessage("欢迎新人~ 欢迎来到年糕的编程/编曲群")
            }
        }
    }
}