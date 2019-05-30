package com.guilla.lab.mvp.listeners

import com.guilla.lab.Model.Repository

/**
 * Created by Franck Guill.
 */
interface RepoListListener : BaseListener {

    fun onSuccess(list: List<Repository>?)
}
