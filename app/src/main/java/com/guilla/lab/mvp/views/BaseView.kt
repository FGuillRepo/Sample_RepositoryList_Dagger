package com.guilla.lab.mvp.views

/**
 * Created by dino on 20/03/15.
 */
interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String)
}
