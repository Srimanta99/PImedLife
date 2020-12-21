package com.pimedlife.pimedlife.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.HomeActivity
import com.pimedlife.pimedlife.utils.ApplicationConstant
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            if(AppSheardPreference(this).getvalue_in_preference(PreferenceConstent.iS_LOGIN).equals("true")) {
                val homeactivity = Intent(this, HomeActivity::class.java)
                startActivity(homeactivity)
                finish()
            }else{
                val introActivity = Intent(this, IntroActivity::class.java)
                startActivity(introActivity)
                finish()
            }
        }, ApplicationConstant.SPLASH_TIME)
    }
}