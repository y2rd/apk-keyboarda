package com.example.android.architecture.blueprints.todoapp.data

import com.example.android.architecture.blueprints.todoapp.util.AppMessageQueue

class FakeAppMessageQueue : AppMessageQueue {

    private val fakePrefs = mutableMapOf<String, Int>()

    override fun produce(message: Int) {
        fakePrefs["message"] = message
    }

    override fun consume(): Int {
        return fakePrefs.remove("message") ?: 0
    }

}