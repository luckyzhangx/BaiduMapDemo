package com.luckyzhangx.practice.baidumapdemo.core

import android.app.Application
import com.baidu.mapapi.SDKInitializer

// Created by luckyzhangx on 2018/10/29.
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SDKInitializer.initialize(this)
    }
}