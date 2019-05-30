package com.guilla.lab.activities

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import com.guilla.lab.R
import com.guilla.lab.dagger.components.AppComponent
import com.guilla.lab.fragment.Repository_fragment
import com.guilla.lab.mvp.views.BaseView


class RepositoryActivity : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container_fragment, Repository_fragment.newInstance(), "Repository_fragment")
                    .commit()
        }
    }


    override fun onCreateOptionsMenu(pMenu: Menu): Boolean {
        return true
    }


    public override fun onResume() {
        super.onResume()

    }


    public override fun onSaveInstanceState(savedState: Bundle) {
        super.onSaveInstanceState(savedState)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.repeatCount == 0) {
            Log.d("CDA", "onKeyDown Called")
            onBackPressed()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    public override fun onPause() {
        super.onPause()

    }

    public override fun onDestroy() {
        super.onDestroy()
    }



}





