package com.example.openeyes.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.DividerNormalDecoration
import com.example.openeyes.adapter.HomeRecyclerAdapter
import com.example.openeyes.databean.Item
import com.example.openeyes.databinding.FaxianFragmentBinding
import com.hjq.toast.ToastUtils
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
        setRecycler()
        setRecyclerDivider()
        setSmartRefreshLayout()
    }

    private fun getDataCallback() {
        viewModel.mHomeFaxianList.observe(viewLifecycleOwner, Observer {
            if (dataList.isNotEmpty()) dataList.clear()
            dataList.addAll(it)
        })
    }

    //设置recycler
    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        faxian_recycler.layoutManager = layoutManager
        context?.let {
            faxian_recycler.adapter = HomeRecyclerAdapter(it, dataList)
        }
    }
    //设置recycler分割线
    private fun setRecyclerDivider(){
        faxian_recycler.addItemDecoration(DividerNormalDecoration(context!!))
    }
    //设置SmartRefreshLayout
    private fun setSmartRefreshLayout(){
        refreshLayout.setRefreshHeader(ClassicsHeader(context)); //经典头
        refreshLayout.setOnRefreshListener {
            viewModel.getFaxianList()
            faxian_recycler.adapter!!.notifyDataSetChanged()
            it.finishRefresh(100 /*,false*/) //传入false表示刷新失败
        }
        refreshLayout.setEnableLoadMore(false)
    }
}