package com.pimedlife.pimedlife.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.dashboard.DashBoardFragment

class TopBannerAdapter(val activity: FragmentActivity?,val dashBoardFragment: DashBoardFragment) : RecyclerView.Adapter<TopBannerAdapter.ViewHolder>() {


    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(activity).inflate(R.layout.item_top_slider_layout,null)
       return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return  8
    }
}