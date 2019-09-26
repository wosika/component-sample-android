package com.dosmono.sanya.architecture.app

import android.content.Context
import androidx.core.util.Preconditions
import com.dosmono.sanya.architecture.di.AppComponent

object Kits {



    fun obtainAppComponentFromContext(context: Context): AppComponent {
        Preconditions.checkNotNull(context, "${context::class.java.name} cannot be null")
        Preconditions.checkState(
            context.applicationContext is IAPP,
            "${context.applicationContext.javaClass.name} must be implements ${IAPP::class.java.name}"
        )
        return (context.applicationContext as IAPP).getAppComponent()
    }
}