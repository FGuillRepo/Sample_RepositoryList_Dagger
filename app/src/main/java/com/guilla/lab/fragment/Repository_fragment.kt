package com.guilla.lab.fragment


import android.content.Intent
import android.os.Bundle

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.guilla.lab.R
import com.guilla.lab.activities.RepositoryDetailsActivity
import com.guilla.lab.adapters.RepositoryAdapter
import com.guilla.lab.dagger.components.AppComponent
import com.guilla.lab.dagger.modules.RepositoryListModule
import com.guilla.lab.mvp.presenters.RepoListPresenter
import com.guilla.lab.mvp.views.RepoListView
import kotlinx.android.synthetic.main.fragment_repository.*

import java.util.ArrayList

import com.guilla.lab.Model.Repository
import com.guilla.lab.utils.Utils


import javax.inject.Inject

class Repository_fragment : BaseFragment(), RepoListView, RepositoryAdapter.repositoryClickListener {

    @Inject
    lateinit var utils: Utils

    @set:Inject
    internal var repositoryListPresenter: RepoListPresenter? = null

    private lateinit var inflate: View

    companion object {
        fun newInstance(): Repository_fragment {
            val myFragment = Repository_fragment()
            val args = Bundle()
            myFragment.arguments = args
            return myFragment
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let { ButterKnife.bind(it) }

        recyclerview?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerview?.layoutManager = layoutManager
        recyclerview?.itemAnimator = DefaultItemAnimator()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         inflate = inflater.inflate(R.layout.fragment_repository, container, false)

        if (utils.isConnected(context)) {
            repositoryListPresenter?.loadrepositoryList()
        }
        return inflate
    }

    override fun injectDependencies(appComponent: AppComponent?) {
        appComponent?.plus(RepositoryListModule(this))?.inject(this)
    }

    override fun showRepositorys(repository: List<Repository>?) {
        var repo = ArrayList<Repository?>(repository)
        val RepositoryAdapter = RepositoryAdapter(repo)
        RepositoryAdapter.setrepositoryClickListener(this)
        recyclerview?.adapter = RepositoryAdapter
        RepositoryAdapter?.notifyDataSetChanged()

    }

    override fun onRepositoryClicked(repository: Repository?) {
        repositoryListPresenter?.onRepositorySelected(repository)
    }

    override fun showRepositoryDetails(repository: Repository) {
        val intent = Intent(activity, RepositoryDetailsActivity::class.java)
        intent.putExtra(RepositoryDetailsActivity.EXTRA_Repository, repository)
        startActivity(intent)
    }

    override fun onDestroy() {
        repositoryListPresenter?.cancel()
        super.onDestroy()
    }
}