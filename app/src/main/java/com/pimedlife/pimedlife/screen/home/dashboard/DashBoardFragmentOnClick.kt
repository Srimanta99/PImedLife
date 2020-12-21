package com.pimedlife.pimedlife.screen.home.dashboard

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.search.Searchctivity

class DashBoardFragmentOnClick(
  val  activity: FragmentActivity?,
  val  dashboardFragmentViewBind: DashboardFragmentViewBind) : View.OnClickListener {
  init {
    dashboardFragmentViewBind.tvsecrch.setOnClickListener(this)
  }

  override fun onClick(p0: View?) {
    when(p0!!.id){
      R.id.tvsecrch->{
        val searchintent=Intent(activity,Searchctivity::class.java)
        activity!!.startActivity(searchintent)
      }
    }
  }

}