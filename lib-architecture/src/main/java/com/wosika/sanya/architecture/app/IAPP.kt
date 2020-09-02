package com.wosika.sanya.architecture.app

import com.wosika.sanya.architecture.di.AppComponent

open interface IAPP {
    fun getAppComponent(): AppComponent
}