package com.niangaoa.niangaos_bot.multi_thread

import com.niangaoa.niangaos_bot.bot.IBotMessage
import com.niangaoa.niangaos_bot.message.*

object MessageStorage {
    val messageList : List<List<IBotMessage>>
    get() = sortedMessageList
    private val sortedMessageList = ArrayList<ArrayList<IBotMessage>>()
    private val messageListBuffer = arrayListOf<IBotMessage>(
        BotCommunicate(),
        BotGuessMusic(),
        BotHelp(),
        BotKFC(),
        BotRandom(),
        BotStudy(),
        BotWelcome()
    )

    init {
        when(messageListBuffer.size) {
            1 -> sortedMessageList.add(messageListBuffer)
            in 2..5 -> {
                val arrayList1 = ArrayList<IBotMessage>()
                val arrayList2 = ArrayList<IBotMessage>()

                for (i in 0 until messageListBuffer.size) {
                    if (i in 0 until messageListBuffer.size / 2) {
                        arrayList1.add(messageListBuffer[i])
                    }else {
                        arrayList2.add(messageListBuffer[i])
                    }
                }
                sortedMessageList.add(arrayList1)
                sortedMessageList.add(arrayList2)
            }
            in 6..10 -> {
                val arrayList1 = ArrayList<IBotMessage>()
                val arrayList2 = ArrayList<IBotMessage>()
                val arrayList3 = ArrayList<IBotMessage>()

                for (i in 0 until messageListBuffer.size) {
                    when(i) {
                        in 0 until messageListBuffer.size / 3 -> arrayList1.add(messageListBuffer[i])
                        in messageListBuffer.size / 3 until messageListBuffer.size / 3 * 2 -> arrayList2.add(messageListBuffer[i])
                        else -> arrayList3.add(messageListBuffer[i])
                    }
                }
                sortedMessageList.add(arrayList1)
                sortedMessageList.add(arrayList2)
                sortedMessageList.add(arrayList3)
            }
            in 11..15 -> {
                val arrayList1 = ArrayList<IBotMessage>()
                val arrayList2 = ArrayList<IBotMessage>()
                val arrayList3 = ArrayList<IBotMessage>()
                val arrayList4 = ArrayList<IBotMessage>()

                for (i in 0 until messageListBuffer.size) {
                    when(i) {
                        in 0 until messageListBuffer.size / 4 -> arrayList1.add(messageListBuffer[i])
                        in messageListBuffer.size / 4 until messageListBuffer.size / 4 * 2 -> arrayList2.add(messageListBuffer[i])
                        in messageListBuffer.size / 4 * 2 until messageListBuffer.size / 4 * 3 -> arrayList3.add(messageListBuffer[i])
                        else -> arrayList4.add(messageListBuffer[i])
                    }
                }
                sortedMessageList.add(arrayList1)
                sortedMessageList.add(arrayList2)
                sortedMessageList.add(arrayList3)
                sortedMessageList.add(arrayList4)
            }
            else -> {
                val arrayList1 = ArrayList<IBotMessage>()
                val arrayList2 = ArrayList<IBotMessage>()
                val arrayList3 = ArrayList<IBotMessage>()
                val arrayList4 = ArrayList<IBotMessage>()
                val arrayList5 = ArrayList<IBotMessage>()

                for (i in 0 until messageListBuffer.size) {
                    when(i) {
                        in 0 until messageListBuffer.size / 5 -> arrayList1.add(messageListBuffer[i])
                        in messageListBuffer.size / 5 until messageListBuffer.size / 5 * 2 -> arrayList2.add(messageListBuffer[i])
                        in messageListBuffer.size / 5 * 2 until messageListBuffer.size / 5 * 3 -> arrayList3.add(messageListBuffer[i])
                        in messageListBuffer.size / 5 * 3 until messageListBuffer.size / 5 * 4 -> arrayList4.add(messageListBuffer[i])
                        else -> arrayList5.add(messageListBuffer[i])
                    }
                }
                sortedMessageList.add(arrayList1)
                sortedMessageList.add(arrayList2)
                sortedMessageList.add(arrayList3)
                sortedMessageList.add(arrayList4)
                sortedMessageList.add(arrayList5)
            }
        }
    }
}