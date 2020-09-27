package com.example.openeyes.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openeyes.R
import com.example.openeyes.adapter.TabViewPagerAdapter
import com.example.openeyes.home.FaxianFragment
import com.example.openeyes.home.RibaoFragment
import com.example.openeyes.home.TuijianFragment
import com.example.openeyes.message.HudongFragment
import com.example.openeyes.message.SixinFragment
import com.example.openeyes.message.TuisongFragment
import com.example.openeyes.viewmodel.MessageViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.home_fragment.*

class MessageFragment : Fragment() {
    private var list_fragment: ArrayList<Fragment>? = null
    private var list_title: ArrayList<String>? = null
    private var adapter: TabViewPagerAdapter? = null

    private lateinit var viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
        ininView()
        initTabAndPager()
    }

    private fun ininView() {
        list_fragment = ArrayList()
        val tsFragment = TuisongFragment()
        val hdFragment = HudongFragment()
        val sxFragment = SixinFragment()
        list_fragment?.add(tsFragment)
        list_fragment?.add(hdFragment)
        list_fragment?.add(sxFragment)
        list_title = ArrayList()
        list_title?.add("推送")
        list_title?.add("互动")
        list_title?.add("私信")
    }
    private fun initTabAndPager(){
        tablayout.tabMode = TabLayout.MODE_FIXED
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(0)))
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(1)))
        tablayout.addTab(tablayout.newTab().setText(list_title?.get(2)))
        adapter = TabViewPagerAdapter(childFragmentManager, list_fragment!!, list_title!!)
        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)
    }
}