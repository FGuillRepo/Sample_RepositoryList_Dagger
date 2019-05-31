package com.guilla.lab.dagger.modules

import com.squareup.okhttp.OkHttpClient

import android.util.Log

import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

import javax.inject.Named
import javax.inject.Singleton

import com.guilla.lab.network.RepositoryService
import com.guilla.lab.utils.Utils
import dagger.Module
import dagger.Provides
import retrofit.Endpoint
import retrofit.RestAdapter
import retrofit.client.OkClient

/**
 * Created by dino on 12/05/15.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideUtils() : Utils {
        return  Utils
    }
    @Provides
    @Singleton
    fun provideLogger(): RestAdapter.Log {
        return RestAdapter.Log { message -> Log.d("REST-ADAPTER", message) }
    }

    @Provides
    @Singleton
    fun provideClient(networkTimeout: Int?): OkHttpClient {
        val okHttpClient = OkHttpClient()
        okHttpClient.setConnectTimeout(networkTimeout!!.toLong(), TimeUnit.SECONDS)
        okHttpClient.setReadTimeout(networkTimeout.toLong(), TimeUnit.SECONDS)
        return okHttpClient
    }


    @Provides
    @Singleton
    fun provideService(endpoint: Endpoint, @Named("HttpExecutor") httpExecutor: Executor,
                       @Named("CallbackExecutor") callbackExecutor: Executor, client: OkHttpClient,
                       log: RestAdapter.Log): RepositoryService {

        return RestAdapter.Builder()
                .setClient(OkClient(client))
                .setEndpoint(endpoint)
                .setLog(log)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setExecutors(httpExecutor, callbackExecutor)
                .build().create(RepositoryService::class.java!!)
    }
}
