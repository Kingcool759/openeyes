package com.example.openeyes.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @data on 2020/9/25 2:54 PM
 * @auther
 * @describe
 */
class TabViewPagerAdapter(
    fm: FragmentManager,
   var list_fragment: List<Fragment>,
   var list_Title: List<String>
) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return list_fragment[position]
    }

    override fun getCount(): Int {
        return list_fragment.size
    }

    // 此方法用来显示tab上的名字
    override fun getPageTitle(position: Int): CharSequence? {
        return list_Title[position % list_Title.size]
    }

}