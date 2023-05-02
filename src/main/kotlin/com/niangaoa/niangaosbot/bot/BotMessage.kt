package com.niangaoa.niangaosbot.bot

import com.niangaoa.niangaosbot.BotMain
import com.niangaoa.niangaosbot.tools.MainConfigDataUtils
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.GlobalEventChannel

/**
 * 所有操作消息的基类
 * 实例化了DataUtils
 * @see MainConfigDataUtils
 * @author niangaoa
 */
abstract class BotMessage : IBotMessage, Runnable{
    protected val mainConfigDataUtils = MainConfigDataUtils()
    private val eventChannel = GlobalEventChannel.parentScope(BotMain)
    override fun botEventChannel(event: EventChannel<Event>) {}
    override fun run() {
        botEventChannel(eventChannel)
    }
}