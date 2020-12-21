package com.pimedlife.pimedlife.screen.registration

import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import com.pimedlife.pimedlife.R

class RegistrationViewBind(registrationActivity: RegistrationActivity, view: View) {
    val  img_back:ImageView=view.findViewById(R.id.img_back)
    val  tie_email: TextInputEditText=view.findViewById(R.id.tie_email)
    val  til_fname:TextInputEditText=view.findViewById(R.id.til_fname)
    val  til_lname: TextInputEditText=view.findViewById(R.id.til_lname)
    val  til_pass:TextInputEditText=view.findViewById(R.id.til_pass)
    val  til_conpass: TextInputEditText=view.findViewById(R.id.til_conpass)
    val btn_submit:Button=view.findViewById(R.id.btn_submit)
}