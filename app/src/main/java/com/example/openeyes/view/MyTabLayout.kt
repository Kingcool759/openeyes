package com.example.openeyes.view

import android.content.Context
import android.util.AttributeSet
import com.example.openeyes.R
import com.google.android.material.tabs.TabLayout

/**
 * @data on 2020/9/25 4:10 PM
 * @auther
 * @describe
 */
class MyTabLayout : TabLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setSelectedTabIndicator(R.drawable.tablayout_indicator)
    }

}