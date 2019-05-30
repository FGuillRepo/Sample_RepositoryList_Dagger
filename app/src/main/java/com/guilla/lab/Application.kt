package com.guilla.lab

import android.app.Application

import com.guilla.lab.dagger.components.AppComponent
import com.guilla.lab.dagger.components.DaggerAppComponent

open class Application : Application() {

    var applicationComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        applicationComponent = DaggerAppComponent.create()
    }

    companion object {

        var instance: com.guilla.lab.Application? = null
    }
}
