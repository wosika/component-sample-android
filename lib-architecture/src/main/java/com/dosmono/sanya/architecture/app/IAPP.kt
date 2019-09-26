package com.dosmono.sanya.architecture.app

import com.dosmono.sanya.architecture.di.AppComponent

open interface IAPP {
    fun getAppComponent(): AppComponent
}