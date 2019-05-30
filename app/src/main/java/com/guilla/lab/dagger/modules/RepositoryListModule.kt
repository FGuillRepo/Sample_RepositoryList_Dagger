package com.guilla.lab.dagger.modules

import com.guilla.lab.dagger.scopes.ActivityScope
import com.guilla.lab.mvp.interactors.RepoListInteractor
import com.guilla.lab.mvp.interactors.impl.ListInteractorImpl
import com.guilla.lab.mvp.presenters.RepoListPresenter
import com.guilla.lab.mvp.presenters.impl.ListPresenterImpl
import com.guilla.lab.mvp.views.RepoListView
import dagger.Module
import dagger.Provides

/**
 * Created by dino on 12/05/15.
 */
@Module
class RepositoryListModule(private val view: RepoListView) {

    @ActivityScope
    @Provides
    fun provideView(): RepoListView {
        return view
    }

    @ActivityScope
    @Provides
    fun provideInteractor(interactor: ListInteractorImpl): RepoListInteractor {
        return interactor
    }

    @ActivityScope
    @Provides
    fun providePresenter(presenter: ListPresenterImpl): RepoListPresenter {
        return presenter
    }
}
