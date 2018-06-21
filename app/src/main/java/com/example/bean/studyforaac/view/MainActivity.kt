package com.example.bean.studyforaac.view

import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.example.bean.studyforaac.R
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.bean.studyforaac.adapter.ViewPagerAdpter
import com.example.bean.studyforaac.databinding.ActivityMainBinding
import com.example.bean.studyforaac.view.articleListFragement.OnFragmentInteractionListener


class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {


    //by lazy 쓰는것이 android UI 관리 측면에서 좋다고 함..
    val mbinding : ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding }
    val mViewPager : ViewPager by lazy { mbinding.articleViewPager }
    val mTablayout : TabLayout by lazy { mbinding.categoryTabLayout }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding.isLoading = true
//        1. normal
//        setContentView(R.layout.activity_main)
//        2. init for databinding in OnCreate
//        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setToolbar()
        setupViewPager()
        setupTabs()

    }

    fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
    }

    fun setupViewPager() {
        val adapter = ViewPagerAdpter(getSupportFragmentManager())
        val categories = resources.getStringArray(R.array.category)

        for (caterogy in categories)
            adapter.addFrag( articleListFragement.newInstance(caterogy, "") , caterogy)

        mViewPager.adapter = adapter
    }

    fun setupTabs() {
        mTablayout.setupWithViewPager(mViewPager)
        mTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mViewPager.setCurrentItem(tab.position)

                Log.i("ddd", tab.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onFragmentInteraction(uri: Uri) {
        Log.i("ddd", "dddddddddddddd")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
