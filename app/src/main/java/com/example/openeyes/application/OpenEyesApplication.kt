package com.example.openeyes.application

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication


/**
 * @data on 2020/9/29 3:17 PM
 * @auther
 * @describe
 */
class OpenEyesApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this) //必须
    }
}