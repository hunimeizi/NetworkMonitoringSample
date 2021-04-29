package com.haolin.network.monitoring.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.haolin.network.monitoring.annotation.NetWork
import com.haolin.network.monitoring.manager.NetWorkManager
import com.haolin.network.monitoring.type.NetType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NetWorkManager.getDefault().registerObserver(this)
    }

    @NetWork(netType = NetType.AUTO)
    fun netWork(netType: NetType) {
        when (netType) {
            NetType.WIFI -> Log.e("lyb======", netType.name)

            NetType.CMNET, NetType.CMWAP -> Log.e("lyb======", "流量=" + netType.name)

            NetType.NONE -> Log.e("lyb======", "没有网络")

            else ->
                Log.e("lyb======", "没有网络")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        NetWorkManager.getDefault().unRegisterObserver(this)
        NetWorkManager.getDefault().unRegisterAllObserver()
    }
}