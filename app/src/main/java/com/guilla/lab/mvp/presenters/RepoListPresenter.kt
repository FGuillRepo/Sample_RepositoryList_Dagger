package com.guilla.lab.mvp.presenters

import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
interface RepoListPresenter : BasePresenter {

    fun loadrepositoryList()

    fun onRepositorySelected(repository: Repository?)
}
