package com.example.bean.studyforaac.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.support.design.widget.TabLayout
import com.example.bean.studyforaac.R
import android.support.v7.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//                DataBindingUtil.setContentView(this, R.layout.activity_main)

        setToolbar()
    }

    fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
    }

    fun setTab() {

    }
}
