package com.example.openeyes.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openeyes.R
import com.example.openeyes.adapter.TabViewPagerAdapter
import com.example.openeyes.community.GuanzhuFragment
import com.example.openeyes.community.Tuijian2Fragment
import com.example.openeyes.home.FaxianFragment
import com.example.openeyes.home.RibaoFragment
import com.example.openeyes.home.TuijianFragment
import com.example.openeyes.viewmodel.CommunityViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.home_fragment.*

class CommunityFrgment : Fragment() {
    private var list_fragment: ArrayList<Fragment>? = null
    private var list_title: ArrayList<String>? = null
    private var adapter: TabViewPagerAdapter? = null

    private lateinit var viewModel: CommunityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.community_frgment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommunityViewModel::class.java)
        ininView()
        tablayout.tabMode = TabLayout.MODE_FIXED
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(0)))
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(1)))
        adapter = TabViewPagerAdapter(childFragmentManager, list_fragment!!, list_title!!)
        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)
    }

    private fun ininView() {
        list_fragment = ArrayList()
        val tjFragment = Tuijian2Fragment()
        val gzFragment = GuanzhuFragment()
        list_fragment?.add(tjFragment)
        list_fragment?.add(gzFragment)
        list_title = ArrayList()
        list_title?.add("推荐")
        list_title?.add("关注")
    }
}