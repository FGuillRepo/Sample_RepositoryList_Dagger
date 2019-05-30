package com.guilla.lab.dagger.modules

import com.guilla.lab.BuildConfig
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit.Endpoint
import retrofit.Endpoints

/**
 * Created by dino on 27/02/15.
 */
@Module
class HostModule {

    @Provides
    @Singleton
    fun provideEndpoint(): Endpoint {
        return Endpoints.newFixedEndpoint(BuildConfig.API_URL)
    }

    @Provides
    @Singleton
    fun provideNetworkTimeout(): Int? {
        return NETWORK_TIMEOUT_SECONDS
    }

    companion object {

        val NETWORK_TIMEOUT_SECONDS = 10
    }
}
