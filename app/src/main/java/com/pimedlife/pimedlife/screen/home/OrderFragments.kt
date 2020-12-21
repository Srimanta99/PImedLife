package com.pimedlife.pimedlife.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pimedlife.pimedlife.R

class OrderFragments :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
    companion object {
        fun newInstance(): OrderFragments = OrderFragments()
    }
}