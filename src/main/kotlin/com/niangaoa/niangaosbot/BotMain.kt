package com.niangaoa.niangaosbot

import com.niangaoa.niangaosbot.bot.BotName
import com.niangaoa.niangaosbot.config.BotMainConfig
import com.niangaoa.niangaosbot.factory.BotMessageFactory
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

/**
 * Mirai的主类
 * @author niangaoa
 * */
object BotMain : KotlinPlugin(
    JvmPluginDescription(
        id = "com.niangaoa.niangaosbot",
        name = "年糕的机器人",
        version = "0.0.1"
    )
) {
    private val botMessageFactory = BotMessageFactory()

    override fun onEnable() {
        this.reloadMainConfig()
        logger.info { "插件载入成功~欢迎使用"}
        addEvent()
    }

    /**
     * 重新加载config，调用BotConfig.init()
     * @see BotMainConfig
     * */
    fun reloadMainConfig() {
        BotMainConfig.init()
    }

    private fun addEvent() {
        botMessageFactory.getEvent(BotName.botCommunicate)?.start()
        botMessageFactory.getEvent(BotName.botHelp)?.start()
        botMessageFactory.getEvent(BotName.botRandom)?.start()
    }
}