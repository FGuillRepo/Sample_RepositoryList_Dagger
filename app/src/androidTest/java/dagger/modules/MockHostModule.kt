package dagger.modules

import com.squareup.okhttp.mockwebserver.MockWebServer

import java.io.IOException

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
        }

    }

    @Provides
    fun provideEndpoint(): Endpoint {
        return Endpoints.newFixedEndpoint(mockWebServer.getUrl("/").toString())
    }
}
