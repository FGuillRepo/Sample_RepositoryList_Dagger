package com.guilla.lab.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.guilla.lab.R
import javax.inject.Inject


/**
 * Created by Moi on 29/01/2017.
 */

object Utils {


    fun isConnected(context: Context?): Boolean {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netinfo = cm.activeNetworkInfo

        if (netinfo != null && netinfo.isConnectedOrConnecting) {
            val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

            return if (mobile != null && mobile.isConnectedOrConnecting || wifi != null && wifi.isConnectedOrConnecting)
                true
            else
                false
        } else
            return false
    }


    interface Click {
        fun Ok()

        fun Cancel()
    }


    fun showDialog(activity: Context, message: String, title: String, hideCancel: Boolean, ok: Click) {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_network_connectivity)

        val text = dialog.findViewById<View>(R.id.text_dialog) as TextView
        val titleTV = dialog.findViewById<View>(R.id.titletext) as TextView
        val dialogButton = dialog.findViewById<View>(R.id.btn_dialog) as Button
        val cancelBtn = dialog.findViewById<View>(R.id.cancel_btn) as Button
        text.text = message

        if (hideCancel) {
            cancelBtn.visibility = View.INVISIBLE
            cancelBtn.isClickable = false
        } else {
            cancelBtn.visibility = View.VISIBLE
            cancelBtn.isClickable = true
        }

        titleTV.text = title
        titleTV.visibility = View.VISIBLE
        dialogButton.setOnClickListener {
            ok.Ok()
            dialog.dismiss()
        }
        cancelBtn.setOnClickListener {
            ok.Cancel()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showToastConnectivity(context: Context) {
        val message = context.getString(R.string.error_network_problem)
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.show()
    }


}


