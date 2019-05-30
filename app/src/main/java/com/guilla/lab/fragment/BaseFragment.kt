package com.guilla.lab.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html

import com.guilla.lab.Application
import com.guilla.lab.R
import com.guilla.lab.dagger.components.AppComponent
import com.guilla.lab.mvp.views.BaseView

/**
 * Created by Franck Guill.
 */
abstract class BaseFragment : Fragment(), BaseView {

    protected var progressDialog: Dialog? = null

    protected abstract fun injectDependencies(appComponent: AppComponent?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(Application.instance?.applicationComponent)

    }

    protected fun showProgressDialog() {
        if (progressDialog == null || !progressDialog?.isShowing!!) {
            progressDialog = ProgressDialog(activity)
            progressDialog?.setCanceledOnTouchOutside(false)
            if (!activity?.isFinishing!!) {
                progressDialog?.show()
            }
        }
    }

    protected fun hideProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            if (!activity?.isFinishing!!) {
                progressDialog?.dismiss()
            }
        }
    }

    protected fun showDialog(message: String?) {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle(R.string.app_name)
        if (message != null) {
            builder.setMessage(Html.fromHtml(message))
        } else {
            builder.setMessage("")
        }
        builder.setPositiveButton(android.R.string.ok, null)

        if (!activity?.isFinishing!!) {
            builder.show()
        }
    }

    override fun showProgress() {
        showProgressDialog()
    }

    override fun hideProgress() {
        hideProgressDialog()
    }

    override fun showError(message: String) {
        showDialog(message)
    }
}
