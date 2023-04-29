package com.niangaoa.niangaosbot

import com.niangaoa.niangaosbot.config.BotMainConfig
import com.niangaoa.niangaosbot.factory.BotMessageFactory
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.utils.info

/**
 * Mirai的主类
 * @author niangaoa
 * */
object BotMain : KotlinPlugin(
    JvmPluginDescription(
        id = "com.niangaoa.mywife",
        name = "年糕的老婆插件",
        version = "0.0.1"
    )
) {
    private lateinit var eventChannel : EventChannel<Event>
    private val botMessageFactory = BotMessageFactory()

    override fun onEnable() {
        this.reloadMainConfig()
        logger.info { "插件载入成功~欢迎使用"}
        eventChannel = GlobalEventChannel.parentScope(this)
        addEvent()
        System.err.println(BotMainConfig.getGottenMap())
    }

    /**
     * 重新加载config，调用WifeConfig.init()
     * @see BotMainConfig
     * */
    fun reloadMainConfig() {
        BotMainConfig.init()
    }

    private fun addEvent() {
        botMessageFactory.getEvent("Communicate")?.wifeEventChannel(eventChannel)
        botMessageFactory.getEvent("Random")?.wifeEventChannel(eventChannel)
        botMessageFactory.getEvent("Help")?.wifeEventChannel(eventChannel)
    }
}