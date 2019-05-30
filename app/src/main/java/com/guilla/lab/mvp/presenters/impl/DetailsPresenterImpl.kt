package com.guilla.lab.mvp.presenters.impl

import javax.inject.Inject

import com.guilla.lab.mvp.interactors.RepoDetailsInteractor
import com.guilla.lab.mvp.listeners.RepoDetailsListener
import com.guilla.lab.mvp.presenters.RepoDetailsPresenter
import com.guilla.lab.mvp.views.RepoDetailsView
import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
class DetailsPresenterImpl @Inject
constructor(private val RepositoryDetailsView: RepoDetailsView, private val RepositoryDetailsInteractor: RepoDetailsInteractor) : RepoDetailsPresenter, RepoDetailsListener {

    override fun loadDetails(repository: Repository) {
        RepositoryDetailsView.showProgress()
        RepositoryDetailsInteractor.loadRepositoryDetails(repository?.gitUrl!!, this)
    }

    override fun cancel() {
        RepositoryDetailsView.hideProgress()
        RepositoryDetailsInteractor.cancel()
    }

    override fun onSuccess(repository: Repository) {
        // APIs are not to be trusted so we wrap interaction with data from API in try/catch
        try {
           /* RepositoryDetailsView.showName(repository?.name!!)
            RepositoryDetailsView.showHp(repository.hp.toString())
            RepositoryDetailsView.showWeight(repository.weight!!)
            RepositoryDetailsView.showHeight(repository.height!!)
            RepositoryDetailsView.showAttack(repository.attack.toString())
            RepositoryDetailsView.showDefense(repository.defense.toString())*/
        } catch (e: Exception) {
            e.printStackTrace()
            RepositoryDetailsView.showError("Unknown error while using data from API!")
        } finally {
            RepositoryDetailsView.hideProgress()
        }
    }

    override fun onFailure(message: String) {
        RepositoryDetailsView.hideProgress()
        RepositoryDetailsView.showError(message)
    }
}
