package com.example.bean.studyforaac.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
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

private const val CATEGORY = "category"
private const val ARG_PARAM2 = "param2"

class articleListFragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var category: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var mBinding : FragmentArticleListBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(CATEGORY)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        val view : View = inflater.inflate(R.layout.fragment_article_list, container, false)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false)

//        val linearLayoutManager = LinearLayoutManager(activity!!.baseContext)
//        recyclerView.layoutManager = linearLayoutManager

        mBinding.newsList.setHasFixedSize(true)

        val newsList: MutableList<newsItem> = arrayListOf()
        val a : String = "aaaaaaaa"
        val b : String = "bbbbbbbbb"
        newsList.add( newsItemModel(category.toString() , category!!,category!! ,category!! ,category!! ,category!! ,category!! ,category!! ) )
        newsList.add( newsItemModel(a ,a ,a ,a ,a ,a ,a ,a ) )
        newsList.add( newsItemModel(b ,b ,b ,b ,b ,b ,b ,b ) )
        newsList.add( newsItemModel(a ,a ,a ,a ,a ,a ,a ,a ) )
        newsList.add( newsItemModel(b ,b ,b ,b ,b ,b ,b ,b ) )

        mBinding.newsList.adapter = newsAdapter(newsList, context)


        return mBinding.root
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(category: String, param2: String) =
                articleListFragement().apply {
                    arguments = Bundle().apply {
                        putString(CATEGORY, category)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
