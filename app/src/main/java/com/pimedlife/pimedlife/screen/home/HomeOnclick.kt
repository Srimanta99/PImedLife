package com.pimedlife.pimedlife.screen.home

import android.content.Intent
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.dashboard.DashBoardFragment
import com.pimedlife.pimedlife.screen.home.profile.ProfileFragment
import com.pimedlife.pimedlife.screen.login.LoginActivity
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent

class HomeOnclick(val homeActivity: HomeActivity,val  homeViewBind: HomeViewBind) :
    BottomNavigationView.OnNavigationItemSelectedListener {
   init {
       homeViewBind.bottomNavigationView.setOnNavigationItemSelectedListener (this)
   }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_home -> {

                val homeFragment = DashBoardFragment.newInstance()
                homeActivity.openFragment(homeFragment)
                return true
            }
            R.id.navigation_orders -> {
                val orderFragments = OrderFragments.newInstance()
                homeActivity.openFragment(orderFragments)
                return true
            }
            R.id.navigation_account -> {

                if(AppSheardPreference(homeActivity).getvalue_in_preference(PreferenceConstent.iS_LOGIN).equals("true")) {
                    val profileFragment = ProfileFragment.newInstance()
                    homeActivity.openFragment(profileFragment)
                }else{
                    val introActivity = Intent(homeActivity, LoginActivity::class.java)
                    homeActivity.startActivity(introActivity)
                   // homeActivity.finish()
                }

                return true
            }
        }

     return false
    }
}