package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.BotMain
import com.niangaoa.niangaosbot.bot.BotMessage
import com.niangaoa.niangaosbot.config.BotMainConfig
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

/**
 * 是一个帮助类，含有管理员才能执行的“重载配置”指令(在AdminMembers里设置)
 * 继承了WifeMessage
 * @author niangaoa
 * @see BotMessage
 * */
class BotHelp : BotMessage() {
    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            if (message.content == "重载配置") {
                //进行了管理员判断
                if (mainConfigDataUtils.isGottenAdminInConfig(sender)) {
                    BotMain.reloadMainConfig()
                    sender.sendMessage("重载成功，允许的管理员有：\n" +
                            "${BotMainConfig.gottenJson["AdminMembers"]}\n\n"
                            + "允许的群聊有：\n" +
                            "${BotMainConfig.gottenJson["AcceptedGroups"]}\n\n" +
                            "允许的成员有(部分小功能)：\n" +
                            "${BotMainConfig.gottenJson["AcceptedMembers"]}\n\n" +
                            "禁止的群聊有：\n" +
                            "${BotMainConfig.gottenJson["BanedGroups"]}\n\n" +
                            "禁止的成员有：\n" +
                            "${BotMainConfig.gottenJson["BanedMembers"]}")
                } else {
                    group.sendMessage("权限不足，请检查配置文件")
                }
            }
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (message.content == "帮助列表") {
                    group.sendMessage(
                            "目前已有指令：\n" +
                            "一.普通指令\n" +
                            "1.随机生成a,b(a和b必须为大于等于0小于10的数)\n" +
                            "2.帮助列表\n\n" +
                            "二.管理员使用\n" +
                            "1.重载配置\n" +
                            "2.监督@谁谁谁")
                }
            }
        }
    }
}
