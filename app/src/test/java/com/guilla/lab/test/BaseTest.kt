package com.guilla.lab.test

import com.google.gson.Gson

import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import com.squareup.okhttp.mockwebserver.RecordedRequest

import org.junit.Before
import org.robolectric.shadows.ShadowLog

import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

import com.guilla.lab.RepoTestApp
import com.guilla.lab.helpers.ResourceUtils

/**
 * Created by Željko Plesac on 07/09/15.
 */
open class BaseTest {

    private var mockWebServer: MockWebServer? = null

    protected val gson: Gson
        get() = RepoTestApp.gson

    @Before
    @Throws(Exception::class)
    fun setup() {
        mockWebServer = RepoTestApp.mockWebServer

        ShadowLog.stream = System.out
    }

    protected fun enqueueResponse(filename: String) {
        val body = ResourceUtils.readFromFile(filename)
        val mockResponse = MockResponse().setBody(body).setResponseCode(HttpURLConnection.HTTP_OK)
        mockWebServer!!.enqueue(mockResponse)
    }

    protected fun enqueueResponse(filename: String, statusCode: Int) {
        val body = ResourceUtils.readFromFile(filename)
        val mockResponse = MockResponse().setBody(body).setResponseCode(statusCode)
        mockWebServer!!.enqueue(mockResponse)
    }

    protected fun enqueueEmptyResponse(statusCode: Int) {
        val mockResponse = MockResponse().setBody("").setResponseCode(statusCode)
        mockWebServer!!.enqueue(mockResponse)
    }

    @Throws(InterruptedException::class)
    protected fun takeLastRequest(): RecordedRequest {
        var requestCount = mockWebServer!!.requestCount
        while (requestCount > 1) {
            mockWebServer!!.takeRequest(10, TimeUnit.SECONDS)
            requestCount--
        }

        return mockWebServer!!.takeRequest(10, TimeUnit.SECONDS)
    }
}
