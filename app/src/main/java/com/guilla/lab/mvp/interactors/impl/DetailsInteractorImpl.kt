package com.guilla.lab.mvp.interactors.impl

import javax.inject.Inject

import com.guilla.lab.mvp.interactors.RepoDetailsInteractor
import com.guilla.lab.mvp.listeners.RepoDetailsListener
import com.guilla.lab.network.RepositoryService
import com.guilla.lab.Model.Repository
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

/**
 * Created by Franck Guill.
 */
class DetailsInteractorImpl @Inject
constructor(private val RepositoryService: RepositoryService) : RepoDetailsInteractor, Callback<Repository> {

    private var RepositoryDetailsListener: RepoDetailsListener? = null

    private var isCanceled: Boolean = false

    override fun loadRepositoryDetails(resourceUri: String, RepositoryDetailsListener: RepoDetailsListener) {
        reset()
        this.RepositoryDetailsListener = RepositoryDetailsListener
        RepositoryService.getRepositoryDetails(resourceUri, this)
    }

    override fun cancel() {
        isCanceled = true
    }

    override fun reset() {
        isCanceled = false
    }

    override fun success(repository: Repository, response: Response) {
        if (!isCanceled) {
            RepositoryDetailsListener!!.onSuccess(repository)
        }
    }

    override fun failure(error: RetrofitError?) {
        if (!isCanceled) {
            RepositoryDetailsListener!!.onFailure(error?.message!!)
        }
    }
}
