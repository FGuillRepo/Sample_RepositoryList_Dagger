package com.guilla.lab.mvp.listeners

import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
interface RepoDetailsListener : BaseListener {

    fun onSuccess(repository: Repository)
}
