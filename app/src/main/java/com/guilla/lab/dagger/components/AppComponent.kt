package com.guilla.lab.dagger.components

import javax.inject.Singleton

import com.guilla.lab.Application
import com.guilla.lab.dagger.modules.DefaultExecutorsModule
import com.guilla.lab.dagger.modules.HostModule
import com.guilla.lab.dagger.modules.NetworkModule
import com.guilla.lab.dagger.modules.RepositoryDetailsModule
import com.guilla.lab.dagger.modules.RepositoryListModule
import dagger.Component

/**
 * Created by dino on 13/10/15.
 */
@Component(modules = [NetworkModule::class, HostModule::class, DefaultExecutorsModule::class])
@Singleton
interface AppComponent {

    fun inject(app: Application)

    operator fun plus(repositoryListModule: RepositoryListModule): RepositoryListComponent

    operator fun plus(RepositoryDetailsModule: RepositoryDetailsModule): RepositoryDetailsComponent

}
