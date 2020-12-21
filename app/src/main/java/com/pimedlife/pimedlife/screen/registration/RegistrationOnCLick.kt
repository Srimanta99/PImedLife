package com.pimedlife.pimedlife.screen.registration

import android.view.View
import com.pimedlife.pimedlife.R

class RegistrationOnCLick(
    val registrationActivity: RegistrationActivity,
    val registrationViewBind: RegistrationViewBind) : View.OnClickListener {
    init {
        registrationViewBind.btn_submit.setOnClickListener(this)
        registrationViewBind.img_back.setOnClickListener(this)

    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_submit->{
                checkvalidation()
            }
            R.id.img_back->{
                registrationActivity.finish()
            }
        }

    }

    private fun checkvalidation() {
        if(registrationViewBind.tie_email.text.toString().equals("")){
            registrationViewBind.tie_email.requestFocus()
            return
        }
        if(registrationViewBind.til_fname.text.toString().equals("")){
            registrationViewBind.til_fname.requestFocus()
            return
        }
        if(registrationViewBind.til_lname.text.toString().equals("")){
            registrationViewBind.til_fname.requestFocus()
            return
        }
        if(registrationViewBind.til_pass.text.toString().equals("")){
            registrationViewBind.til_pass.requestFocus()
            return
        }
        if(registrationViewBind.til_conpass.text.toString().equals("")){
            registrationViewBind.til_conpass.requestFocus()
            return
        }
        if(!registrationViewBind.til_conpass.text!!.equals(registrationViewBind.til_pass.text.toString())){
            registrationViewBind.til_conpass.requestFocus()
            return
        }
        callApiforregistration();
    }

    private fun callApiforregistration() {

    }
}