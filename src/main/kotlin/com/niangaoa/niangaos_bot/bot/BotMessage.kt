package com.niangaoa.niangaos_bot.bot

import com.niangaoa.niangaos_bot.tools.MainConfigDataUtils

/**
 * 所有操作消息的基类
 * 实例化了DataUtils
 * @see MainConfigDataUtils
 * @author niangaoa
 */
abstract class BotMessage{
    protected val mainConfigDataUtils = MainConfigDataUtils()
}