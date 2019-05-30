package com.guilla.lab.mvp.presenters

import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
 interface RepoDetailsPresenter : BasePresenter {

    fun loadDetails(repository: Repository)
}
