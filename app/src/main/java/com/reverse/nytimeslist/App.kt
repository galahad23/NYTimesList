package com.reverse.nytimeslist

import android.app.Application
import io.paperdb.Paper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Paper.init(this)
    }

    companion object {
        var instance: App? = null
    }
}