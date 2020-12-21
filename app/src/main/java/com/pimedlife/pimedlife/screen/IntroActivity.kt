package com.pimedlife.pimedlife.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.adapter.SliderImageAdapter
import com.pimedlife.pimedlife.screen.login.LoginActivity
import com.rd.PageIndicatorView

class IntroActivity : AppCompatActivity() {
    private var currentPage = 0
    private var NUM_PAGES = 0
    private val IMAGES = arrayOf(R.drawable.med1, R.drawable.med2, R.drawable.med3)
    var pageIndicatorView:PageIndicatorView?=null
    var myViewPager:ViewPager?=null
    var btn_letsStart:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        myViewPager=findViewById(R.id.myViewPager)
        pageIndicatorView=findViewById(R.id.pageIndicatorView)
        btn_letsStart=findViewById(R.id.btn_letsStart)
        btn_letsStart!!.setOnClickListener {
            val loginActivity=Intent(this, LoginActivity::class.java)
            startActivity(loginActivity)
            finish()
        }
        setuppager()
    }

    private fun setuppager() {
        myViewPager!!.adapter= SliderImageAdapter(this,IMAGES)
        myViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                pageIndicatorView!!.setSelection(position);
            }

        })
     //   indicator.setViewPager(mPager)
     //   val density = resources.displayMetrics.density
      //  indicator.radius = 5 * density

        /*indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
        })*/
    }
}