package com.guilla.lab.mvp.views

/**
 * Created by Franck Guill.
 */
interface RepoDetailsView : BaseView {

    fun showName(name: String)

    fun showHp(hp: String)

    fun showWeight(weight: String)

    fun showHeight(height: String)

    fun showAttack(attack: String)

    fun showDefense(defense: String)
}
