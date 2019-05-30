package com.guilla.lab.test

import android.support.test.rule.ActivityTestRule
import android.test.suitebuilder.annotation.LargeTest
import com.guilla.lab.Application
import com.guilla.lab.activities.RepositoryDetailsActivity
import com.guilla.lab.dagger.components.DaggerAppComponent
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Test for [RepositoryDetailsActivity].
 */
@LargeTest
class RepoDetailsEspressoTest {

    /**
     * Rule that defines [RepositoryDetailsActivity] should be started before running tests.
     */
    @Rule
    var activityRule = ActivityTestRule<RepositoryDetailsActivity>(RepositoryDetailsActivity::class.java, true, false)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //TODO Reinject the app with mock networking module.
        DaggerAppComponent.builder()
                .build()
                .inject(Application.instance)

    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun testDetails() {
        //TODO test goes here
    }
}
