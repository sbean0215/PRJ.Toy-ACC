package com.example.bean.studyforaac.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.bean.studyforaac.R
import android.R.menu
import android.support.v7.widget.Toolbar
import android.view.MenuInflater
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()
    }

    fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
    }
}
