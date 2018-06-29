package com.example.bean.studyforaac.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.bean.studyforaac.R
import com.example.bean.studyforaac.adapter.ViewPagerAdpter
import com.example.bean.studyforaac.databinding.ActivityMainBinding
import com.example.bean.studyforaac.model.Article


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    //by lazy 쓰는것이 android UI 관리 측면에서 좋다고 함..
    val mbinding : ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding }
    val mViewPager : ViewPager by lazy { mbinding.articleViewPager }
    val mTablayout : TabLayout by lazy { mbinding.categoryTabLayout }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUI()
    }


    fun showArticle(article: Article) {
        //startActivity for article
        Log.i(TAG, "showArticle")
    }


    fun setUI() {
        //setToolbar
        mbinding.toolbar.inflateMenu(R.menu.main_menu)

        //setupViewPager
        val adapter = ViewPagerAdpter(getSupportFragmentManager())
        val categories = resources.getStringArray(R.array.category)

        for (caterogy in categories)
            adapter.addFrag( articleListFragement.forCategory(caterogy, "") , caterogy)

        mViewPager.adapter = adapter

        //setupTabs
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
