package com.example.android.architecture.blueprints.todoapp.data

import com.example.android.architecture.blueprints.todoapp.util.AppMessageQueue

class FakeAppMessageQueue : AppMessageQueue {

    private val fakePrefs = mutableMapOf<String, Int>()

    override fun setHasPendingMessage(message: Int) {
        fakePrefs["message"] = message
    }

    override fun getPendingMessageOnce(): Int {
        return fakePrefs["message"] ?: 0
    }
}