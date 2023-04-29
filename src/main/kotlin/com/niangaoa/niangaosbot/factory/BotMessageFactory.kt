package com.niangaoa.niangaosbot.factory

import com.niangaoa.niangaosbot.event.BotCommunicate
import com.niangaoa.niangaosbot.event.BotHelp
import com.niangaoa.niangaosbot.event.BotRandom
import com.niangaoa.niangaosbot.bot.BotMessage

class BotMessageFactory {

    fun getEvent(className: String) : BotMessage? {
        if (className == "Communicate") {
            return BotCommunicate()
        }else if (className == "Random") {
            return BotRandom()
        }else if (className == "Help") {
            return BotHelp()
        }
        return null
    }
}