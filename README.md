# 即时网络监听框架
#### 使用方法
1.使用gradle
```js
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'io.github.hunimeizi:haolinNetworkMonitoring:1.0.0'
}
```

2.使用说明

该library采用注解方式进行网络监听类型变化

① 在Application中进行实例化
  ```js
   NetWorkManager.getDefault().init(this)
  ```
② 在需要监听网络的activity 或者 fragment中 进行注册
  ```js
  NetWorkManager.getDefault().registerObserver(this)
  ```
③ 添加网络监听注解方法
  ```js
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
  ```
④ 别忘记注销注册
  ```js
  override fun onDestroy() {
          super.onDestroy()
          NetWorkManager.getDefault().unRegisterObserver(this)
          //以下方法在退出App的时候调用
          NetWorkManager.getDefault().unRegisterAllObserver()
      }
  ```
3.关于混淆
```js
  -keep class com.haolin.network.monitoring.** { *; }
```
#### 内嵌上传 Maven Central
详细请看教程
[JCenter已经提桶跑路，是时候学会上传到Maven Central了](https://mp.weixin.qq.com/s/CrfYc1KsugJKPy_0rDZ49Q)