package com.pimedlife.pimedlife.screen.home

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.dashboard.DashBoardFragment
import com.pimedlife.pimedlife.utils.Converter

class HomeActivity : AppCompatActivity() {
    var view:View?=null
    var homeViewBind:HomeViewBind?=null
    var homeOnclick:HomeOnclick?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view=LayoutInflater.from(this).inflate(R.layout.activity_home,null)
        homeViewBind= HomeViewBind(this,view!!);
        homeOnclick= HomeOnclick(this,homeViewBind!!)
        setContentView(view)
        val homeFragment = DashBoardFragment.newInstance()
        openFragment(homeFragment)

    }

    public fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun ManageCartView(i: Int) {
        val inflatedFrame = layoutInflater.inflate(R.layout.cart_layout, null)
        val item = inflatedFrame.findViewById(R.id.TXT_Counter) as TextView
        if (i <= 0)
            item.visibility = View.GONE
        else
            item.visibility = View.VISIBLE
        item.text = i.toString() + ""
        val drawable = BitmapDrawable(resources, Converter.getBitmapFromView(inflatedFrame))
       // menuCartItem!!.setIcon(drawable)

       // isReadyforCourtCount=true
    }
}