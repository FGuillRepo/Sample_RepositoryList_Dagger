package com.guilla.lab.dagger.components

import com.guilla.lab.activities.RepositoryDetailsActivity
import com.guilla.lab.dagger.modules.RepositoryDetailsModule
import com.guilla.lab.dagger.scopes.ActivityScope
import dagger.Subcomponent

/**
 * Created by dino on 12/05/15.
 */
@ActivityScope
@Subcomponent(modules = [RepositoryDetailsModule::class])
interface RepositoryDetailsComponent {

    fun inject(activity: RepositoryDetailsActivity)
}
