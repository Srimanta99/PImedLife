package com.pimedlife.pimedlife.screen.home.dashboard

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.pimedlife.pimedlife.R

class DashboardFragmentViewBind(
   val activity: FragmentActivity?,
    val dashBoardFragment: DashBoardFragment,
    val view: View) {
    var rec_topadapter:RecyclerView=view.findViewById(R.id.rec_topadapter)
    var tvsecrch:TextView=view.findViewById(R.id.tvsecrch)
}