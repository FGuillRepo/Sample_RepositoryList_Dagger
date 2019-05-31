package com.guilla.lab.dagger.components

import javax.inject.Singleton

import com.guilla.lab.Application
import com.guilla.lab.dagger.modules.*
import dagger.Component


@Component(modules = [NetworkModule::class, HostModule::class, DefaultExecutorsModule::class])
@Singleton
interface AppComponent {

    fun inject(app: Application)

    operator fun plus(repositoryListModule: RepositoryListModule): RepositoryListComponent

    operator fun plus(RepositoryDetailsModule: RepositoryDetailsModule): RepositoryDetailsComponent

}
