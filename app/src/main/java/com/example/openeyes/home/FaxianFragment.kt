package com.example.openeyes.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.HomeRecyclerAdapter
import com.example.openeyes.databean.Item
import com.example.openeyes.databinding.FaxianFragmentBinding
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import kotlinx.android.synthetic.main.faxian_fragment.*


class FaxianFragment : Fragment() {
    private lateinit var binding: FaxianFragmentBinding
    private lateinit var viewModel: HomeViewModel
    private var dataList: ArrayList<Item> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //使用databinding绑定viewmodel
        binding = DataBindingUtil.inflate(inflater, R.layout.faxian_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getFaxianList()
        getDataCallback()
        setSmartRefreshLayout()
    }

    private fun getDataCallback() {
        viewModel.mHomeFaxianList.observe(viewLifecycleOwner, Observer {
            dataList.addAll(it)
            setHomeRecycler()
        })
    }


    //设置recycler
    private fun setHomeRecycler() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        home_recycler.layoutManager = layoutManager
        context?.let {
            home_recycler.adapter = HomeRecyclerAdapter(it, dataList)
        }
    }
    //设置SmartRefreshLayout
    private fun setSmartRefreshLayout(){
        refreshLayout.setRefreshHeader(ClassicsHeader(context)); //经典头
        refreshLayout.setRefreshFooter(ClassicsFooter(context)); //经典尾
//        refreshLayout.setRefreshHeader(BezierRadarHeader(context).setEnableHorizontalDrag(true)) //雷达刷新头
//        refreshLayout.setRefreshHeader(new MaterialHeader(this));//谷歌刷新头
//        refreshLayout.setRefreshHeader(new TwoLevelHeader(this));//二级刷新头
//        refreshLayout.setRefreshFooter(BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale)) //脉冲尾
        refreshLayout.setOnRefreshListener { refreshlayout ->
            refreshlayout.finishRefresh(1000 /*,false*/) //传入false表示刷新失败
        }
        refreshLayout.setOnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(1000 /*,false*/) //传入false表示加载失败
        }
    }
}