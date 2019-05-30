package com.guilla.lab

import com.google.gson.Gson

import com.squareup.okhttp.mockwebserver.MockWebServer

import org.robolectric.TestLifecycleApplication

import android.annotation.SuppressLint

import java.lang.reflect.Method

import com.guilla.lab.dagger.modules.MockHostModule

/**
 * Test application that is run instead of [Application] when Robolectric tests are run.
 */
class RepoTestApp : Application(), TestLifecycleApplication {

    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        // Don't call super so the dependencies don't get injected.
        instance = this
    }

    /**
     * Prepares the MockWebServer before each test
     */
    fun beforeTest(method: Method) {
        val mockHostModule = MockHostModule()
        setMockWebServer(mockHostModule)
        val appTestComponent = DaggerAppTestComponent.builder()
                .mockHostModule(mockHostModule)
                .build()
        appTestComponent.inject(this)
    }

    fun prepareTest(test: Any) {

    }

    fun afterTest(method: Method) {
        try {
            mockWebServer!!.shutdown()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {

        var mockWebServer: MockWebServer? = null
            private set

        fun setMockWebServer(mockHostModule: MockHostModule) {
            mockWebServer = mockHostModule.mockWebServer
        }

        val gson: Gson
            get() = Gson()
    }
}
