package com.niangaoa.niangaosbot.config

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.*
import java.nio.charset.StandardCharsets

/**
 * 用来对config.json进行操作的类
 * @author niangaoa
 * */
object BotMainConfig {
    private val file = File("config/MyWife/GroupConfig.json")
    private val folder = File("config/MyWife")
    private val gson = Gson()
    private val initJson = HashMap<String, List<Long>>()
    var gottenJson = HashMap<String, JsonArray>()
        private set

    /**
     * 初始化GroupConfig.json
     * 如果没有此文件就新建，有就存至gottenJson
     * */
    fun initMainConfig() {
        initJson["AcceptedGroups"]
        initJson["AcceptedMembers"]
        initJson["BanedGroups"]
        initJson["BanedMembers"]
        initJson["AdminMembers"]
        if (file.isFile) {
            val jsonParser = JsonParser.parseReader(FileReader(file)) as JsonObject
            gottenJson["AcceptedGroups"] = jsonParser.get("AcceptedGroups").asJsonArray
            gottenJson["AcceptedMembers"] = jsonParser.get("AcceptedMembers").asJsonArray
            gottenJson["AdminMembers"] = jsonParser.get("AdminMembers").asJsonArray
            gottenJson["BanedGroups"] = jsonParser.get("BanedGroups").asJsonArray
            gottenJson["BanedMembers"] = jsonParser.get("BanedMembers").asJsonArray
        }else {
            folder.mkdirs()
            file.createNewFile()
            try {
                FileOutputStream(file).use { ops ->
                    val writer = OutputStreamWriter(ops, StandardCharsets.UTF_8)
                    writer.append(gson.toJson(initJson))
                    writer.close()
                    ops.close()
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 用来得到gottenMap的方法
     * @return HashMap<String, JsonArray>
     * */
}