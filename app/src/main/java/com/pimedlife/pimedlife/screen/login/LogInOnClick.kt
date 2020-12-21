package com.pimedlife.pimedlife.screen.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.HomeActivity
import com.pimedlife.pimedlife.screen.registration.RegistrationActivity

class LogInOnClick(val loginActivity: LoginActivity,val logInViewBind: LogInViewBind) : View.OnClickListener{
  init {
      logInViewBind!!.sign_in_button.setOnClickListener(this)
      logInViewBind.submit.setOnClickListener(this)
      logInViewBind.img_back.setOnClickListener(this)
      logInViewBind.tv_skip.setOnClickListener(this)
      logInViewBind.tv_registration.setOnClickListener(this)
      logInViewBind.submit.setOnClickListener(this)
  }
    override fun onClick(p0: View?) {
         when(p0!!.id){
             R.id.sign_in_button->{
                 loginActivity.signIn()
             }
             R.id.tv_skip->{
                 val homeintent= Intent(loginActivity, HomeActivity::class.java)
                 loginActivity.startActivity(homeintent)
                 loginActivity.finish()
             }
             R.id.img_back->{
                 loginActivity.finish()
             }
             R.id.tv_registration->{
                 val regIntent= Intent(loginActivity, RegistrationActivity::class.java)
                 loginActivity.startActivity(regIntent)
             }
             R.id.submit->{
                 Toast.makeText(loginActivity,"Under Developemnt",Toast.LENGTH_LONG).show()
             }
         }
    }

}