package com.guilla.lab.mvp.interactors

import com.guilla.lab.mvp.listeners.RepoListListener

/**
 * Created by Franck Guill.
 */
interface RepoListInteractor : BaseInteractor {

    fun loadrepositoryList(repositoryListListener: RepoListListener)
}
