package com.example.openeyes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.DividerNormalDecoration
import com.example.openeyes.adapter.HomeRecyclerAdapter
import com.example.openeyes.adapter.HomeRibaoAdapter
import com.example.openeyes.databean.Item
import com.example.openeyes.databinding.RibaoFragmentBinding
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import kotlinx.android.synthetic.main.faxian_fragment.*
import kotlinx.android.synthetic.main.ribao_fragment.*

class RibaoFragment : Fragment() {
    private lateinit var binding: RibaoFragmentBinding
    private lateinit var viewModel: HomeViewModel
    private var dataList: ArrayList<Item> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //使用databinding绑定viewmodel
        binding = DataBindingUtil.inflate(inflater, R.layout.ribao_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getRibaoList()
        getDataCallback()
        setSmartRefreshLayout()
    }

    private fun getDataCallback() {
        viewModel.mHomeRibaoList.observe(viewLifecycleOwner, Observer {
            dataList.addAll(it)
            setRecycler()
        })
    }


    //设置recycler
    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        ribaoRecycler.layoutManager = layoutManager
        context?.let {
            ribaoRecycler.adapter = HomeRibaoAdapter(it, dataList)
            ribaoRecycler.addItemDecoration(DividerNormalDecoration(context!!))
        }
    }

    //设置SmartRefreshLayout
    private fun setSmartRefreshLayout(){
        ribaoRefreshLayout.setRefreshHeader(ClassicsHeader(context)); //经典头
        ribaoRefreshLayout.setRefreshFooter(ClassicsFooter(context)); //经典尾
//        refreshLayout.setRefreshHeader(BezierRadarHeader(context).setEnableHorizontalDrag(true)) //雷达刷新头
//        refreshLayout.setRefreshHeader(new MaterialHeader(this));//谷歌刷新头
//        refreshLayout.setRefreshHeader(new TwoLevelHeader(this));//二级刷新头
//        refreshLayout.setRefreshFooter(BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale)) //脉冲尾
        ribaoRefreshLayout.setOnRefreshListener { refreshlayout ->
            refreshlayout.finishRefresh(1000 /*,false*/) //传入false表示刷新失败
        }
        ribaoRefreshLayout.setOnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(1000 /*,false*/) //传入false表示加载失败
        }
    }
}