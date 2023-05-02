package com.niangaoa.niangaosbot.factory

import com.niangaoa.niangaosbot.event.BotCommunicate
import com.niangaoa.niangaosbot.event.BotHelp
import com.niangaoa.niangaosbot.event.BotRandom
import com.niangaoa.niangaosbot.event.BotStudy

class BotMessageFactory {

    fun getEvent(className: String) : Thread? {
        when (className) {
            "Communicate" -> return Thread(BotCommunicate())
            "Random" -> return Thread(BotRandom())
            "Help" -> return Thread(BotHelp())
            "Study" -> return Thread(BotStudy())
        }
        return null
    }
}