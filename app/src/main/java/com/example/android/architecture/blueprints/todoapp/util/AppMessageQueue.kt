package com.example.android.architecture.blueprints.todoapp.util

import android.content.SharedPreferences
import androidx.core.content.edit


interface AppMessageQueue {
    fun setHasPendingMessage(message: Int)
    fun getPendingMessageOnce(): Int
}

class AppMessageQueueImpl(private val prefs: SharedPreferences) : AppMessageQueue{


    companion object{
        const val MESSAGE_KEY = "AppMessageQueue.message_key"
    }

    override fun setHasPendingMessage(message: Int) {
        prefs.edit(commit = true){ putInt(MESSAGE_KEY, message) }
    }

    override fun getPendingMessageOnce(): Int {
        return prefs.getInt(MESSAGE_KEY, 0)
            .also{
                prefs.edit(commit = true){ remove(MESSAGE_KEY)}
            }
    }


}