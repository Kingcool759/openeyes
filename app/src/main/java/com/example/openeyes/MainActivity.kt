package com.example.openeyes

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.openeyes.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mFragments by lazy {
        arrayOf(
            HomeFragment(),
            CommunityFrgment(),
            MessageFragment(),
            MineFragment()
        )
    }
    private var mPreFragmentFlag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        selectFragment()

        sendImageView.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"fabu",Toast.LENGTH_SHORT).show()
        })
    }

    private fun initFragment() {
        initLoadFragment(R.id.mContainerView, 0, mFragments)
    }

    // 参数一 是一个FrameLayout的ID，用来动态加载Fragment，
    private fun initLoadFragment(
        containerId: Int,
        showFragment: Int,
        fragments: Array<Fragment>
    ) {
        //获取到FragmentManager实例的同时去开启事物
        val transaction =
            supportFragmentManager.beginTransaction()
        for (i in fragments.indices) {
            //首先将Fragment添加到事务中
            transaction.add(containerId, fragments[i])
            //默认展示 fragments[showFragment]
            //这里做首次Fragment的展示，如果不是指定的Fragment就先隐藏，需要的时候再显示出来
            if (i != showFragment) transaction.hide(fragments[i])
        }
        //提交事物
        transaction.commitAllowingStateLoss()
    }

    private fun selectFragment() {
        //注册监听事件
        mBottomNav.itemIconTintList = null
        mBottomNav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    showAndHideFragment(mFragments[0], mFragments[mPreFragmentFlag])
                    mPreFragmentFlag = 0
                }
                R.id.wechat -> {
                    showAndHideFragment(mFragments[1], mFragments[mPreFragmentFlag])
                    mPreFragmentFlag = 1
                }
                R.id.system -> {
                    showAndHideFragment(mFragments[2], mFragments[mPreFragmentFlag])
                    mPreFragmentFlag = 2
                }
                R.id.setting -> {
                    showAndHideFragment(mFragments[3], mFragments[mPreFragmentFlag])
                    mPreFragmentFlag = 3
                }
            }
            true
        }
    }

    //加载不同的Fragment
    private fun showAndHideFragment(
        show: Fragment,
        hide: Fragment
    ) {
        val transaction =
            supportFragmentManager.beginTransaction()
        if (show !== hide) transaction.show(show).hide(hide).commitAllowingStateLoss()
    }
}