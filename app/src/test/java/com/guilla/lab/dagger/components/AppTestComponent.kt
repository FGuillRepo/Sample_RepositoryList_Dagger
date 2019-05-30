package com.guilla.lab.dagger.components

import javax.inject.Singleton

import com.guilla.lab.Application
import com.guilla.lab.dagger.modules.MockHostModule
import com.guilla.lab.dagger.modules.SynchronousExecutorsModule
import dagger.Component

/**
 * Created by dino on 13/10/15.
 */
@Component(modules = [MockHostModule::class, SynchronousExecutorsModule::class, ApiModule::class])
@Singleton
interface AppTestComponent {

    fun inject(app: Application)
}
