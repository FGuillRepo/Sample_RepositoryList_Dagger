package com.guilla.lab.helpers

import com.google.gson.Gson

import org.junit.runners.model.InitializationError
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.robolectric.internal.bytecode.InstrumentationConfiguration
import org.robolectric.manifest.AndroidManifest

import retrofit.converter.GsonConverter

/**
 * Created by zeljkoplesac on 05/02/15.
 */
class CustomRobolectricGradleTestRunner @Throws(InitializationError::class)
constructor(testClass: Class<*>) : RobolectricGradleTestRunner(testClass) {

    protected fun getAppManifest(config: Config): AndroidManifest {
        val appManifest = super.getAppManifest(config)
        appManifest.setPackageName("com.guilla.lab") // needs to be the java package name, not applicationId
        return appManifest
    }

    fun createClassLoaderConfig(): InstrumentationConfiguration {
        val builder = InstrumentationConfiguration.newBuilder()
        builder.addInstrumentedClass(Gson::class.java!!.getName())
        builder.addInstrumentedClass(GsonConverter::class.java!!.getName())
        return builder.build()
    }
}
