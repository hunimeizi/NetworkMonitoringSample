package com.haolin.network.monitoring.sample

import android.app.Application
import com.haolin.network.monitoring.manager.NetWorkManager

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NetWorkManager.getDefault().init(this)
    }
}