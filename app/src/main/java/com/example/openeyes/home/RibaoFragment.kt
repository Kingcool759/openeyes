package com.example.openeyes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
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
        setRecyclerDivider()
        setSmartRefreshLayout()
        setRecycler()
    }

    private fun getDataCallback() {
        viewModel.mHomeRibaoList.observe(viewLifecycleOwner, Observer {
            //先把之前的Recycler中的数据清空，再重新填充数据
            if (dataList.isNotEmpty()) dataList.clear()
            dataList.addAll(it)
        })
    }


    //设置recycler
    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        ribaoRecycler.layoutManager = layoutManager
        context?.let {
            ribaoRecycler.adapter = HomeRibaoAdapter(it, dataList)
        }
    }
    //设置recycler的分割线
    private fun setRecyclerDivider() {
        ribaoRecycler.addItemDecoration(DividerNormalDecoration(context!!))
    }

    //设置SmartRefreshLayout
    private fun setSmartRefreshLayout() {
        ribaoRefreshLayout.setRefreshHeader(ClassicsHeader(context)); //经典头
        ribaoRefreshLayout.setRefreshFooter(ClassicsFooter(context)); //经典尾
        ribaoRefreshLayout.setOnRefreshListener { refreshlayout ->
            viewModel.getRibaoList()
            // getDataCallback()  //自动触发观察者模式改变数据
            ribaoRecycler.adapter!!.notifyDataSetChanged()
            refreshlayout.finishRefresh(1000 /*,false*/) //传入false表示刷新失败
        }
        ribaoRefreshLayout.setOnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(500 /*,false*/) //传入false表示加载失败
        }
    }
}