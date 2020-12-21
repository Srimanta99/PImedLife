
package com.pimedlife.pimedlife.screen.search

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.pimedlife.pimedlife.databinding.ActivitySearchBinding


class Searchctivity : AppCompatActivity() {
    var activitySearchBinding: ActivitySearchBinding?=null

    var searchActivityOnClick:SearchActivityOnClick?=null
    var searchActivityViewBind:SearchActivityViewBind?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         activitySearchBinding= ActivitySearchBinding.inflate(LayoutInflater.from(this));
        setContentView(activitySearchBinding!!.getRoot())
        searchActivityViewBind= SearchActivityViewBind(this,activitySearchBinding)
        searchActivityOnClick= SearchActivityOnClick(this,searchActivityViewBind!!)
    }
}