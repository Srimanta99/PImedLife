package com.pimedlife.pimedlife.screen.home.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pimedlife.pimedlife.R

class ProfileFragment :Fragment(){
     var profileViewBind:ProfileViewBind?=null
     var profileOnclick:ProfileOnclick?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=LayoutInflater.from(activity).inflate(R.layout.fragment_profile, container, false)
        profileViewBind= ProfileViewBind(activity,this,view)
        ProfileOnclick(activity,this,profileViewBind!!)
        return view
    }
    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}