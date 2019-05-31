package com.guilla.lab.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView

import butterknife.ButterKnife
import com.guilla.lab.Model.Repository
import com.guilla.lab.R
import kotlinx.android.synthetic.main.activity_repository_details.view.*
import kotlinx.android.synthetic.main.list_item_repository.view.*
import java.util.*

/**
 * Created by Franck Guill.
 */
class RepositoryAdapter(private val repositoryList: ArrayList<Repository?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var repositoryclickListener: repositoryClickListener? = null

    init {
        Log.d("Listddd", repositoryList.get(0).toString())

        Collections.sort(this.repositoryList) { lhs, rhs -> lhs?.id!! - rhs?.id!! }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_repository, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val repository = getItem(position)
        viewHolder?.itemView?.repo_id?.text = "#" + repository?.name
        viewHolder?.itemView.repo_name?.text = repository?.language
        viewHolder?.itemView?.setOnClickListener {

            if (repositoryclickListener != null) {
                repositoryclickListener?.onRepositoryClicked(repository)
            }
        }
    }


    override fun getItemCount(): Int {
        return repositoryList?.size
    }
    fun getItem(position: Int): Repository? {
        return repositoryList?.get(position)
    }

    fun setrepositoryClickListener(repositoryClickListener: repositoryClickListener) {
        this.repositoryclickListener = repositoryClickListener
    }

    class ViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {

        @BindView(R.id.repo_id)
        internal var RepositoryId: TextView? = null

        @BindView(R.id.repo_name)
        internal var RepositoryName: TextView? = null

        init {
            ButterKnife.bind(this, rootView)
        }
    }

    interface repositoryClickListener {

        fun onRepositoryClicked(repository: Repository?)
    }
}
