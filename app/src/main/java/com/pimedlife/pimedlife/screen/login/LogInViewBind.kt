package com.pimedlife.pimedlife.screen.login

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.common.SignInButton
import com.pimedlife.pimedlife.R

class LogInViewBind(val loginActivity: LoginActivity,val view: View){
    val  submit: ImageView=view.findViewById(R.id.submit)
    var sign_in_button:SignInButton=view.findViewById(R.id.sign_in_button);
    val img_back:ImageView=view.findViewById(R.id.img_back)
    val tv_skip:TextView=view.findViewById(R.id.tv_skip)
    val tv_registration:TextView=view.findViewById(R.id.tv_registration)
}