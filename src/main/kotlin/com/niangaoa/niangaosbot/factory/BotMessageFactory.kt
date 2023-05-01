package com.niangaoa.niangaosbot.factory

import com.niangaoa.niangaosbot.event.BotCommunicate
import com.niangaoa.niangaosbot.event.BotHelp
import com.niangaoa.niangaosbot.event.BotRandom

class BotMessageFactory {

    fun getEvent(className: String) : Thread? {
        when (className) {
            "Communicate" -> return Thread(BotCommunicate())
            "Random" -> return Thread(BotRandom())
            "Help" -> return Thread(BotHelp())
        }
        return null
    }
}