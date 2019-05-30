package com.guilla.lab.dagger.modules

import java.util.concurrent.Executor
import java.util.concurrent.Executors

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit.android.MainThreadExecutor

/**
 * This module uses  to inject HTTP Client
 * and Callback executors. This implementation of Executors inject the default executors set
 * up by Retrofit RestClient.Builder.
 */
@Module
class DefaultExecutorsModule {

    @Provides
    @Singleton
    @Named("HttpExecutor")
    fun provideHttpExecutor(): Executor {
        return Executors.newCachedThreadPool()
    }

    @Provides
    @Singleton
    @Named("CallbackExecutor")
    fun provideCallbackExecutor(): Executor {
        return MainThreadExecutor()
    }
}

