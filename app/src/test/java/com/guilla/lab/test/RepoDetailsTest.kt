package com.guilla.lab.test

import com.squareup.okhttp.mockwebserver.MockResponse

import junit.framework.Assert

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

import android.content.Intent
import android.widget.TextView

import com.guilla.lab.RepoTestApp
import com.guilla.lab.R
import com.guilla.lab.activities.RepositoryDetailsActivity
import com.guilla.lab.helpers.CustomRobolectricGradleTestRunner
import com.guilla.lab.shadows.ShadowGson
import com.guilla.lab.utils.ResourceUtils

import org.assertj.android.api.Assertions.assertThat


/**
 * Created by ivan on 12/10/15.
 */
@RunWith(CustomRobolectricGradleTestRunner::class)
@Config(shadows = { ShadowGson.class })
class RepoDetailsTest : BaseTest() {

    private fun buildActivity(pokemon: Pokemon): RepositoryDetailsActivity {
        val intent = Intent(RuntimeEnvironment.application, RepositoryDetailsActivity::class.java)
        intent.putExtra(RepositoryDetailsActivity.EXTRA_POKEMON, pokemon)
        return Robolectric.buildActivity(RepositoryDetailsActivity::class.java)
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .visible()
                .get()
    }

    @Test
    @Throws(Exception::class)
    fun shouldMakeRequestToCorrectResourceUri() {
        val resourceUri = "api/v1/pokemon/6/"
        val pokemon = Pokemon()
        pokemon.resourceUri = resourceUri

        val activity = buildActivity(pokemon)

        val request = takeLastRequest()
        Assert.assertEquals("/$resourceUri", request.path)
    }

    @Test
    @Throws(Exception::class)
    fun nameOk() {
        RepoTestApp.mockWebServer!!.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody(ResourceUtils.readFromFile("charizard.json"))
        )

        val resourceUri = "api/v1/pokemon/6/"
        val pokemon = Pokemon()
        pokemon.resourceUri = resourceUri

        val activity = buildActivity(pokemon)

        val request = takeLastRequest()

        //Check that name in details is displayed properly.
        assertThat(activity.findViewById<View>(R.id.name)).isVisible()
        assertThat(activity.findViewById<View>(R.id.name) as TextView).hasText("Charizard")
    }
}
