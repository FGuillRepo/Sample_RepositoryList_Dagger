package com.guilla.lab.mvp.interactors.impl

import javax.inject.Inject

import com.guilla.lab.mvp.interactors.RepoListInteractor
import com.guilla.lab.mvp.listeners.RepoListListener
import com.guilla.lab.network.RepositoryService
import com.guilla.lab.Model.Repository
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

/**
 * Created by Franck Guill.
 */
class ListInteractorImpl @Inject
constructor(private val RepositoryService: RepositoryService) : RepoListInteractor, Callback<List<Repository>> {

    private var repositoryListListener: RepoListListener? = null

    private var isCanceled: Boolean = false

    override fun loadrepositoryList(repositoryListListener: RepoListListener) {
        reset()
        this.repositoryListListener = repositoryListListener
        RepositoryService.getPokedex(this)
    }

    override fun cancel() {
        isCanceled = true
    }

    override fun reset() {
        isCanceled = false
    }

    override fun success(repository: List<Repository>?, response: Response) {
        if (!isCanceled) {
            repositoryListListener?.onSuccess(repository)
        }
    }

    override fun failure(error: RetrofitError?) {
        if (!isCanceled) {
            repositoryListListener?.onFailure(error?.message!!)
        }
    }
}
