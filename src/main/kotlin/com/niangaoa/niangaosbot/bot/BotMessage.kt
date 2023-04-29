package com.niangaoa.niangaosbot.bot

import com.niangaoa.niangaosbot.api.IBotMessage
import com.niangaoa.niangaosbot.tools.MainConfigDataUtils
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel

/**
 * 所有操作消息的基类
 * 实例化了DataUtils
 * @see MainConfigDataUtils
 * @author niangaoa
 */
abstract class BotMessage : IBotMessage {
    protected val mainConfigDataUtils = MainConfigDataUtils()
    override fun wifeEventChannel(event: EventChannel<Event>) {
    }
}