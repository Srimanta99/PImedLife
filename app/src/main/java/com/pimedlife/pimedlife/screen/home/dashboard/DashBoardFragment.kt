package com.pimedlife.pimedlife.screen.home.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.adapter.TopBannerAdapter


class DashBoardFragment: Fragment() {
    var dashboardFragmentViewBind: DashboardFragmentViewBind?=null
    var dashBoardFragmentOnClick: DashBoardFragmentOnClick?=null
    var topBannerAdapter:TopBannerAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view:View = LayoutInflater.from(activity).inflate(R.layout.fragment_dashboard, container, false)
        dashboardFragmentViewBind= DashboardFragmentViewBind(activity, this, view)
        dashBoardFragmentOnClick= DashBoardFragmentOnClick(activity, dashboardFragmentViewBind!!)
        settopbannerAdapter()
        return view;
    }

    private fun settopbannerAdapter() {
        topBannerAdapter= TopBannerAdapter(activity,this)
        dashboardFragmentViewBind!!.rec_topadapter.setLayoutManager(LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false))
        dashboardFragmentViewBind!!.rec_topadapter.adapter=topBannerAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): DashBoardFragment = DashBoardFragment()
    }
}