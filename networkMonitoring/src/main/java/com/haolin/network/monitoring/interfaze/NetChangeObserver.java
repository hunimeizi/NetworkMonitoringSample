package com.haolin.network.monitoring.interfaze;

import com.haolin.network.monitoring.type.NetType;

public interface NetChangeObserver {

    //网络连接
    void onConnect(NetType netType);

    //网络断开
    void onDisConnect();

}
