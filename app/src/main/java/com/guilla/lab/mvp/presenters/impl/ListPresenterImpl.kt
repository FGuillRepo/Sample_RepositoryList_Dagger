package com.guilla.lab.mvp.presenters.impl

import javax.inject.Inject

import com.guilla.lab.mvp.interactors.RepoListInteractor
import com.guilla.lab.mvp.listeners.RepoListListener
import com.guilla.lab.mvp.presenters.RepoListPresenter
import com.guilla.lab.mvp.views.RepoListView
import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
class ListPresenterImpl @Inject
constructor(private val repositoryListView: RepoListView, private val repositoryListInteractor: RepoListInteractor) : RepoListPresenter, RepoListListener {

    override fun loadrepositoryList() {
        repositoryListView.showProgress()
        repositoryListInteractor.loadrepositoryList(this)
    }

    override fun onRepositorySelected(repository: Repository?) {
        if (repository != null) {
            repositoryListView.showRepositoryDetails(repository)
        }
    }

    override fun cancel() {
        repositoryListView.hideProgress()
        repositoryListInteractor.cancel()
    }

    override fun onSuccess(repository: List<Repository>?) {
        repositoryListView.hideProgress()
        if (repository != null) {
            repositoryListView.showRepositorys(repository)
        }
    }

    override fun onFailure(message: String) {
        repositoryListView.hideProgress()
        repositoryListView.showError(message)
    }
}
