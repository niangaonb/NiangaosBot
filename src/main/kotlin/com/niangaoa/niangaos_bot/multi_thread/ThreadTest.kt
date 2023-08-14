package com.niangaoa.niangaos_bot.multi_thread

import com.niangaoa.niangaos_bot.BotMain
import com.niangaoa.niangaos_bot.bot.IBotMessage
import net.mamoe.mirai.event.GlobalEventChannel

class ThreadTest(
    private val channel1 : IBotMessage,
    private val channel2 : IBotMessage,
    private val channel3 : IBotMessage
) : Runnable {
    private val eventChannel = GlobalEventChannel.parentScope(BotMain)

    override fun run() {
        channel1.botEventChannel(eventChannel)
        channel2.botEventChannel(eventChannel)
        channel3.botEventChannel(eventChannel)
    }
}