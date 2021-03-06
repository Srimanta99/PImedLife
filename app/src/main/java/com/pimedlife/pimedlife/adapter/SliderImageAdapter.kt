package com.pimedlife.pimedlife.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

import androidx.viewpager.widget.ViewPager
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.IntroActivity


class SliderImageAdapter(
        val interPagesActivity: IntroActivity,
        val images: Array<Int>) :PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return  images.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageLayout = LayoutInflater.from(interPagesActivity).inflate(R.layout.intro_slide_item_layout, container, false)!!

        val imageView = imageLayout.findViewById(R.id.image) as ImageView
        imageView.setImageResource(images.get(position))
        container.addView(imageLayout, 0)
        return imageLayout


      //  val view: View = layoutInflater.inflate(layouts.get(position), container, false)
      //  container.addView(view)

       // return view
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
        super.restoreState(state, loader)
    }
    fun clearItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
      //  super.destroyItem(container, position, `object`)
        (container as ViewPager).removeView(`object` as View)
    }
}