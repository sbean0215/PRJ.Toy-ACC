package com.example.bean.studyforaac.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bean.studyforaac.R

private const val CATEGORY = "category"
private const val ARG_PARAM2 = "param2"

class articleListFragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var category: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(CATEGORY)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_article_list, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.news_list_recycler_view)

//        val linearLayoutManager = LinearLayoutManager(activity!!.baseContext)
//        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)


        return view
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
