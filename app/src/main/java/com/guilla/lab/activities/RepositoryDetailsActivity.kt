package com.guilla.lab.activities

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView

import javax.inject.Inject

import butterknife.ButterKnife
import com.guilla.lab.R
import com.guilla.lab.dagger.components.AppComponent
import com.guilla.lab.dagger.modules.RepositoryDetailsModule
import com.guilla.lab.mvp.presenters.RepoDetailsPresenter
import com.guilla.lab.mvp.views.RepoDetailsView
import com.guilla.lab.Model.Repository

public class RepositoryDetailsActivity : BaseActivity(), RepoDetailsView {

    @BindView(R.id.name)
    public var nameText: TextView? = null

    @BindView(R.id.hp)
    public var hpText: TextView? = null

    @BindView(R.id.weight)
    public var weightText: TextView? = null

    @BindView(R.id.height)
    public var heightText: TextView? = null

    @BindView(R.id.attack)
    public var attackText: TextView? = null

    @BindView(R.id.defense)
    public var defenseText: TextView? = null


    @set:Inject
    internal var repoDetailsPresenter: RepoDetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_details)
        ButterKnife.bind(this)

        val repository = intent.getSerializableExtra(EXTRA_Repository) as Repository
        repoDetailsPresenter?.loadDetails(repository)
    }

    override fun injectDependencies(appComponent: AppComponent?) {
        appComponent?.plus(RepositoryDetailsModule(this))?.inject(this)
    }


    override fun onDestroy() {
        repoDetailsPresenter?.cancel()
        super.onDestroy()
    }

    override fun showName(name: String) {
        nameText?.text = name
    }

    override fun showHp(hp: String) {
        hpText?.text = hp
    }

    override fun showWeight(weight: String) {
        weightText?.text = weight
    }

    override fun showHeight(height: String) {
        heightText?.text = height
    }

    override fun showAttack(attack: String) {
        attackText?.text = attack
    }

    override fun showDefense(defense: String) {
        defenseText?.text = defense
    }

    companion object {

        val EXTRA_Repository = "repository"
    }
}
