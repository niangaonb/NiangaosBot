package com.niangaoa.niangaos_bot.message

import com.niangaoa.niangaos_bot.bot.BotMessage
import com.niangaoa.niangaos_bot.bot.IBotMessage
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class BotKFC : BotMessage(), IBotMessage {
    override fun botEventChannel(event: EventChannel<Event>) {
        event.subscribeAlways<GroupMessageEvent> {
            if (mainConfigDataUtils.isGottenGroupInConfig(group)) {
                if (message.content == "疯狂星期四") {
                    val httpClient = HttpClient.newHttpClient()
                    val httpRequest = HttpRequest.newBuilder().uri(URI("https://api.jixs.cc/api/wenan-fkxqs/index.php")).setHeader("Content-Type", "application/json").GET().build()
                    val message = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body()
                    group.sendMessage(message)
                }
            }
        }
    }
}