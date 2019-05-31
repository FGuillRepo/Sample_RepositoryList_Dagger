package com.guilla.lab.dagger.components

import com.guilla.lab.dagger.modules.RepositoryListModule
import com.guilla.lab.dagger.scopes.ActivityScope
import dagger.Subcomponent
import com.guilla.lab.fragment.Repository_fragment

/**
 * Created by dino on 12/05/15.
 */
@ActivityScope
@Subcomponent(modules = [RepositoryListModule::class])
interface RepositoryListComponent {


    fun inject(activity: Repository_fragment)
}
