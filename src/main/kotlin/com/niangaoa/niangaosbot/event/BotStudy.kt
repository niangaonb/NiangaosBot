package com.niangaoa.niangaosbot.event

import com.niangaoa.niangaosbot.bot.BotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

/**学习监督类
 * 注意：这不是机器学习类，只是用来监督不自觉的年糕
 * @author niangaoa
 * */
class BotStudy : BotMessage() {
    //存入获取的qq与是否又说话
    private val targetMap = HashMap<Long, Boolean>()
    //获取qq号
    private val target = StringBuffer()

    override fun botEventChannel(event: EventChannel<Event>) {
        super.botEventChannel(event)
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (mainConfigDataUtils.isGottenAdminInConfig(sender)) {
                    if (message.content.contains("监督")) {
                        target.append(message.content)
                        target.delete(0, 3)
                        group.sendMessage("要认真哦~")
                        if (targetMap.isEmpty()) {
                            targetMap[target.toString().toLong()] = false
                        }
                    }
                    if (target.toString() !== "") {
                        if (sender.id == target.toString().toLong()) {
                            targetMap[target.toString().toLong()] = true
                        }
                        if (targetMap[target.toString().toLong()] == true) {
                            group.sendMessage("说了要好好学习的 哼")
                            group.members[target.toString().toLong()]?.mute(3600)
                            targetMap.clear()
                        }
                    }
                }
            }
        }
    }
}