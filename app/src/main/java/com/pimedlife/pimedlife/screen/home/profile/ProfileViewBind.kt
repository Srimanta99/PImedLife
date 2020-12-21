package com.pimedlife.pimedlife.screen.home.profile

import android.view.TextureView
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.pimedlife.pimedlife.R

class ProfileViewBind(val activity: FragmentActivity?,val profileFragment: ProfileFragment,val view: View) {

         var tv_edit:TextView=view.findViewById(R.id.tv_edit);
         var rl_logout:RelativeLayout=view.findViewById(R.id.rl_logout)

}