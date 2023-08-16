package com.niangaoa.niangaos_bot.multi_thread

import com.niangaoa.niangaos_bot.BotMain
import net.mamoe.mirai.event.GlobalEventChannel

class ThreadStorage {
    val threadList : List<Thread>
        get() = sortedThreadList
    private val eventChannel = GlobalEventChannel.parentScope(BotMain)
    private val sortedThreadList = ArrayList<Thread>()

    fun setOptimizedMessage() {
        for (msgList in MessageStorage.messageList) {
            sortedThreadList.add(Thread {
                msgList.forEach {
                    it.botEventChannel(eventChannel)
                }
            })
        }
    }
}