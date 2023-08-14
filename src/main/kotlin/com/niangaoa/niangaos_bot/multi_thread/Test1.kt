package com.niangaoa.niangaos_bot.multi_thread

import com.niangaoa.niangaos_bot.message.*

object Test1 {
    val t1 = Thread(ThreadTest(BotCommunicate(), BotGuessMusic(), BotHelp()))
    val t2 = Thread(ThreadTest(BotKFC(), BotRandom(), BotStudy()))
}