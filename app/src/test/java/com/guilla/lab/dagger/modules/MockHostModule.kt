package com.guilla.lab.dagger.modules

import com.squareup.okhttp.mockwebserver.MockWebServer

import java.io.IOException

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit.Endpoint
import retrofit.Endpoints

/**
 * Created by dino on 27/02/15.
 */
@Module
class MockHostModule {

    val mockWebServer: MockWebServer

    init {
        mockWebServer = MockWebServer()
        try {
            mockWebServer.start()
        } catch (e: IOException) {
            e.printStackTrace()
            throw RuntimeException("Failed to start mockWebServer!")
        }

    }

    @Provides
    @Singleton
    fun provideEndpoint(): Endpoint {
        return Endpoints.newFixedEndpoint(mockWebServer.url("/").toString())
    }

    @Provides
    @Singleton
    fun provideNetworkTimeout(): Int? {
        return NETWORK_TIMEOUT_SECONDS
    }

    companion object {

        val NETWORK_TIMEOUT_SECONDS = 1
    }
}
