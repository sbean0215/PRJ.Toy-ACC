package com.example.bean.studyforaac.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.example.bean.studyforaac.R
import android.support.v7.widget.Toolbar
import com.example.bean.studyforaac.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

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
        val categorys = resources.getStringArray(R.array.category)

        adapter.addFrag( Fragment() , categorys[0])
        adapter.addFrag( Fragment() , categorys[1])
        adapter.addFrag( Fragment() , categorys[2])
        adapter.addFrag( Fragment() , categorys[3])
        adapter.addFrag( Fragment() , categorys[4])
        adapter.addFrag( Fragment() , categorys[5])
        adapter.addFrag( Fragment() , categorys[7])
    }

    fun setupTabs() {
        mTablayout.setupWithViewPager(mViewPager)
        mTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mViewPager.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}
