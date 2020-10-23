package com.example.openeyes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.openeyes.R
import com.example.openeyes.adapter.TabViewPagerAdapter
import com.example.openeyes.home.FaxianFragment
import com.example.openeyes.home.RibaoFragment
import com.example.openeyes.home.TuijianFragment
import com.example.openeyes.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {
    private var list_fragment: ArrayList<Fragment>? = null
    private var list_title: ArrayList<String>? = null
    private var adapter: TabViewPagerAdapter? = null

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        //tab+fragment
        initView()
        initTabAndPager()
        //业务逻辑

    }

    private fun initView() {
        list_fragment = ArrayList()
        val fxFragment = FaxianFragment()
        val tjFragment = TuijianFragment()
        val rbFragment = RibaoFragment()
        list_fragment?.add(fxFragment)
        list_fragment?.add(tjFragment)
        list_fragment?.add(rbFragment)
        list_title = ArrayList()
        list_title?.add("发现")
        list_title?.add("推荐")
        list_title?.add("日报")
    }

    private fun initTabAndPager(){
        tablayout.tabMode = TabLayout.MODE_FIXED
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(0)))
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(1)))
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(2)))
        adapter = TabViewPagerAdapter(childFragmentManager, list_fragment!!, list_title!!)
        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)
        viewpager.offscreenPageLimit = 3  //设置预加载页面数量，大于则销毁多的
    }
}