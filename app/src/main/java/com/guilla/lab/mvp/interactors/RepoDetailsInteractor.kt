package com.guilla.lab.mvp.interactors

import com.guilla.lab.mvp.listeners.RepoDetailsListener

/**
 * Created by Franck Guill.
 */
interface RepoDetailsInteractor : BaseInteractor {

    fun loadRepositoryDetails(resourceUri: String, RepositoryDetailsListener: RepoDetailsListener)
}
