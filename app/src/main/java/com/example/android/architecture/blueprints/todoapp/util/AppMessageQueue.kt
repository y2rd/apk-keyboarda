package com.example.android.architecture.blueprints.todoapp.util

import android.content.SharedPreferences
import androidx.core.content.edit


interface AppMessageQueue {
    fun produce(message: Int)
    fun consume(): Int
    fun peek(): Int
}

class AppMessageQueueImpl(private val prefs: SharedPreferences) : AppMessageQueue{


    companion object{
        const val MESSAGE_KEY = "AppMessageQueue.message_key"
    }

    override fun produce(message: Int) {
        prefs.edit{ putInt(MESSAGE_KEY, message) }
    }

    override fun consume(): Int {
        val pendingMsg = prefs.getInt(MESSAGE_KEY, 0)
        prefs.edit {
            remove(MESSAGE_KEY)
        }
        return pendingMsg
    }

    override fun peek(): Int {
        return prefs.getInt(MESSAGE_KEY, 0)
    }


}