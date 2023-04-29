package com.niangaoa.niangaosbot.tools

import com.niangaoa.niangaosbot.config.BotMainConfig
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member

/**
 * 顾名思义，这是对数据进行操作的工具类，用来判断得到的组/成员id与配置文件是否相同
 * @author niangaoa
 * */
class MainConfigDataUtils {
    private var dataBool = false

    /**
     * 判断组id是否与配置文件中的id相符或被封禁
     * @param group
     * @return Boolean
     * */
    fun isGottenGroupInConfig(group : Group) : Boolean {
        dataBool = false
        for(vec in 0 until (BotMainConfig.getGottenMap()["AcceptedGroups"]?.size() ?: 1)) {
            if (group.id ==
                (BotMainConfig.getGottenMap()["AcceptedGroups"]?.get(vec)?.asLong ?: 111))
                dataBool = true
        }
        for(vec in 0 until (BotMainConfig.getGottenMap()["BanedGroups"]?.size() ?: 1)) {
            if (group.id ==
                (BotMainConfig.getGottenMap()["BanedGroups"]?.get(vec)?.asLong ?: 111))
                dataBool = false
        }
        return dataBool
    }

    /**
     * 判断成员id是否与配置文件中的id相符或被封禁
     * @param sender
     * @return Boolean
     * */
    fun isGottenSenderInConfig(sender : Member) : Boolean {
        dataBool = false
        for(vec in 0 until (BotMainConfig.getGottenMap()["AcceptedMembers"]?.size() ?: 1)) {
            if (sender.id ==
                (BotMainConfig.getGottenMap()["AcceptedMembers"]?.get(vec)?.asLong ?: 111))
                dataBool = true
        }
        for(vec in 0 until (BotMainConfig.getGottenMap()["BanedMembers"]?.size() ?: 1)) {
            if (sender.id ==
                (BotMainConfig.getGottenMap()["BanedMembers"]?.get(vec)?.asLong ?: 111)) {
                dataBool = false
            }
        }
        return dataBool
    }

    /**
     * 判断成员id是否为管理员(配置中的管理员)
     * @param sender
     * @return Boolean
     * */
    fun isGottenAdminInConfig(sender: Member) : Boolean {
        dataBool = false
        for(vec in 0 until (BotMainConfig.getGottenMap()["AdminMembers"]?.size() ?: 1)) {
            if (sender.id ==
                (BotMainConfig.getGottenMap()["AdminMembers"]?.get(vec)?.asLong ?: 111))
                dataBool = true
        }
        for(vec in 0 until (BotMainConfig.getGottenMap()["BanedMembers"]?.size() ?: 1)) {
            if (sender.id ==
                (BotMainConfig.getGottenMap()["BanedMembers"]?.get(vec)?.asLong ?: 111))
                dataBool = false
        }
        return dataBool
    }

}