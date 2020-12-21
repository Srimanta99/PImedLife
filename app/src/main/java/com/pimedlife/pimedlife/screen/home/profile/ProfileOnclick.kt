package com.pimedlife.pimedlife.screen.home.profile

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.login.LoginActivity
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent

class ProfileOnclick(
    val activity: FragmentActivity?,
    val profileFragment: ProfileFragment,
    val profileViewBind: ProfileViewBind
) : View.OnClickListener {
    init {
        profileViewBind.rl_logout.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.rl_logout -> {
                AppSheardPreference(activity!!).setvalue_in_preference(PreferenceConstent.iS_LOGIN, "false")
                val intent = Intent(activity, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                activity.startActivity(intent)
                activity.finish()
            }
        }
    }
}