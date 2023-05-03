package com.niangaoa.niangaosbot.factory

import com.niangaoa.niangaosbot.event.*

class BotMessageFactory {

    fun getEvent(className: String) : Thread? {
        when (className) {
            "Communicate" -> return Thread(BotCommunicate())
            "Random" -> return Thread(BotRandom())
            "Help" -> return Thread(BotHelp())
            "Study" -> return Thread(BotStudy())
            "Welcome" -> return Thread(BotWelcome())
        }
        return null
    }
}