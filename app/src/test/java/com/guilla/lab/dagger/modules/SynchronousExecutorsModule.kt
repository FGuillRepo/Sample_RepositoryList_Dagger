package com.guilla.lab.dagger.modules

import java.util.concurrent.Executor

import javax.inject.Named

import dagger.Module
import dagger.Provides

/**
 * This module uses to inject HTTP Client
 * and Callback executors. This implementation of Executors run the HTTP Client requests and
 * Callbacks on the same thread as the caller.
 *
 *
 * Beware as this should be used only for testing purposes, running on a device will result in
 * [android.os.NetworkOnMainThreadException].
 */
@Module
class SynchronousExecutorsModule {

    internal inner class SynchronousExecutor : Executor {

        override fun execute(command: Runnable) {
            command.run()
        }
    }

    @Provides
    @Named("HttpExecutor")
    fun provideHttpExecutor(): Executor {
        return SynchronousExecutor()
    }

    @Provides
    @Named("CallbackExecutor")
    fun provideCallbackExecutor(): Executor {
        return SynchronousExecutor()
    }
}
