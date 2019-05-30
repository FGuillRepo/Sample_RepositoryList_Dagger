package com.guilla.lab.mvp.views

import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
interface RepoListView : BaseView {

    fun showRepositorys(Repositorys: List<Repository>?)

    fun showRepositoryDetails(repository: Repository)
}
