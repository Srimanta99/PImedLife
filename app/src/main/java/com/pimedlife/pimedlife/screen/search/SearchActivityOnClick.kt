package com.pimedlife.pimedlife.screen.search

import android.view.View
import com.pimedlife.pimedlife.R

class SearchActivityOnClick(
    val searchctivity: Searchctivity, val activitySearchBinding: SearchActivityViewBind) : View.OnClickListener {
    init {
        activitySearchBinding.img_back.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.imgback->{
                searchctivity.finish()
            }
        }
    }
}