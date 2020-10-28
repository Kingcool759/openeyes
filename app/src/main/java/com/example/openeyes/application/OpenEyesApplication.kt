package com.example.openeyes.application

import android.util.Log
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter


/**
 * @data on 2020/9/29 3:17 PM
 * @auther
 * @describe
 */
class OpenEyesApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openDebug()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openLog()
        }
        ARouter.init(this)
        MultiDex.install(this) //必须
    }
}