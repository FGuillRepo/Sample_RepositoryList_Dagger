package com.guilla.lab.dagger.modules

import com.guilla.lab.dagger.scopes.ActivityScope
import com.guilla.lab.mvp.interactors.RepoDetailsInteractor
import com.guilla.lab.mvp.interactors.impl.DetailsInteractorImpl
import com.guilla.lab.mvp.presenters.RepoDetailsPresenter
import com.guilla.lab.mvp.presenters.impl.DetailsPresenterImpl
import com.guilla.lab.mvp.views.RepoDetailsView
import dagger.Module
import dagger.Provides

/**
 * Created by dino on 12/05/15.
 */
@Module
class RepositoryDetailsModule(private val view: RepoDetailsView) {

    @ActivityScope
    @Provides
    fun provideView(): RepoDetailsView {
        return view
    }

    @ActivityScope
    @Provides
    fun provideInteractor(interactor: DetailsInteractorImpl): RepoDetailsInteractor {
        return interactor
    }

    @ActivityScope
    @Provides
    fun providePresenter(presenter: DetailsPresenterImpl): RepoDetailsPresenter {
        return presenter
    }
}
