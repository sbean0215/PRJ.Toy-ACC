package com.example.bean.studyforaac.view

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bean.studyforaac.R
import com.example.bean.studyforaac.adapter.newsAdapter
import com.example.bean.studyforaac.databinding.FragmentArticleListBinding
import com.example.bean.studyforaac.model.newsItem
import com.example.bean.studyforaac.model.newsItemModel
import com.example.bean.studyforaac.viewmodel.newsListViewModel

private const val CATEGORY = "category"
private const val ARG_PARAM2 = "param2"

class articleListFragement : Fragment() {
    val TAG = "articleListFragement"

    private var category: String? = null

    lateinit var mBinding : FragmentArticleListBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(CATEGORY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false)
        mBinding.newsList.setHasFixedSize(true)

        //
        val newsList: MutableList<newsItem> = arrayListOf()
        val a : String = "aaaaaaaa"
        val b : String = "bbbbbbbbb"
        newsList.add( newsItemModel(category.toString() , category!!,category!! ,category!! ,category!! ,category!! ,category!! ,category!! ) )
        newsList.add( newsItemModel(a ,a ,a ,a ,a ,a ,a ,a ) )
        newsList.add( newsItemModel(b ,b ,b ,b ,b ,b ,b ,b ) )
        newsList.add( newsItemModel(a ,a ,a ,a ,a ,a ,a ,a ) )
        newsList.add( newsItemModel(b ,b ,b ,b ,b ,b ,b ,b ) )
        //

        mBinding.newsList.adapter = newsAdapter(mNewsItemClickCallBack, newsList, context)

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory: newsListViewModel.Factory = newsListViewModel.Factory(category!!)
        val model: newsListViewModel = ViewModelProviders.of(this, factory).get(newsListViewModel::class.java!!)
        subscribeUi(model)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }


    fun subscribeUi(viewModel: newsListViewModel) {
        viewModel.newsList.observe(
                this,
                object: Observer<List<newsItem>> {
                    override fun onChanged(t: List<newsItem>?) {
                        if (t != null) {
                            Log.i("?????","----");
                        } else {
                            Log.i("?????","----!");
                        }
                    }
                }
        )
    }

    val mNewsItemClickCallBack = object : newsClickCallBack {
        override fun onClick(item: newsItemModel) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                //프로덕트에 대한 fragement show
//                (activity as MainActivity).showArticle(item)
                Log.i(TAG, "mNewsItemClickCallBack")
            }
        }
    }

    companion object {
        @JvmStatic
        // 카테고리 주제에 대한 새로운 프래그먼트(뉴스리스트) 생성
        // fun newInstance(category: String, param2: String) =
        fun forCategory(category: String, param2: String) =
                articleListFragement().apply {
                    arguments = Bundle().apply {
                        putString(CATEGORY, category)
                    }
                }
    }
}
