package com.niangaoa.niangaos_bot

import com.niangaoa.niangaos_bot.config.BotMainConfig
import com.niangaoa.niangaos_bot.multi_thread.ThreadStorage
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

/**
 * Mirai的主类
 * @author niangaoa
 * */
object BotMain : KotlinPlugin(
    JvmPluginDescription(
        id = "com.niangaoa.niangaos_bot",
        name = "年糕的机器人",
        version = "0.0.1"
    ) {
        author("niangaoa")
        info("年糕自己的机器人")
    }
) {
    private val threadStorage = ThreadStorage()
    override fun onEnable() {
        reloadMainConfig()
        addEvent()
        logger.info { "插件载入成功~欢迎使用"}
    }

    /**
     * 重新加载config，调用BotConfig.init()
     * @see BotMainConfig
     * */
    fun reloadMainConfig() {
        BotMainConfig.initMainConfig()
    }

    private fun addEvent() {
        threadStorage.setOptimizedMessage()
        threadStorage.threadList.forEach { it.start() }
    }
}