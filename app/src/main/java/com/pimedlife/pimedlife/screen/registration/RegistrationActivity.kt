package com.pimedlife.pimedlife.screen.registration

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.pimedlife.pimedlife.R

class RegistrationActivity: AppCompatActivity() {
    var registrationViewBind:RegistrationViewBind?=null
    var registrationOnCLick:RegistrationOnCLick?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view=LayoutInflater.from(this).inflate(R.layout.activity_registration,null);
        setContentView(view)
        registrationViewBind= RegistrationViewBind(this,view)
        registrationOnCLick=RegistrationOnCLick(this,registrationViewBind!!)
    }
}