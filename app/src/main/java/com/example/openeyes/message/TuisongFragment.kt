package com.example.openeyes.message

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
import com.example.openeyes.adapter.DividerNormalDecoration
import com.example.openeyes.adapter.MessageRecyclerAdapter
import com.example.openeyes.databean.Message
import com.example.openeyes.databinding.TuisongFragmentBinding
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import kotlinx.android.synthetic.main.faxian_fragment.*
import kotlinx.android.synthetic.main.tuisong_fragment.*

class TuisongFragment : Fragment() {
    private lateinit var binding: TuisongFragmentBinding
    private lateinit var viewModel: MessageViewModel
    private var dataList: ArrayList<Message> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tuisong_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getTuisongList()
        getDataCallback()
        setSmartRefreshLayout()
    }

    private fun getDataCallback() {
        viewModel.mMessageTuisongList.observe(viewLifecycleOwner, Observer {
            dataList.addAll(it)
            setHomeRecycler()
        })
    }
    //设置recycler
    private fun setHomeRecycler() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        tuisongRecycler.layoutManager = layoutManager
        context?.let {
            tuisongRecycler.adapter = MessageRecyclerAdapter(it, dataList)
            tuisongRecycler.addItemDecoration(DividerNormalDecoration(context))
        }
    }
    //设置SmartRefreshLayout
    private fun setSmartRefreshLayout(){
        tuisongRefreshLayout.setRefreshHeader(ClassicsHeader(context)); //经典头
        tuisongRefreshLayout.setRefreshFooter(ClassicsFooter(context)); //经典尾
//        refreshLayout.setRefreshHeader(BezierRadarHeader(context).setEnableHorizontalDrag(true)) //雷达刷新头
//        refreshLayout.setRefreshHeader(new MaterialHeader(this));//谷歌刷新头
//        refreshLayout.setRefreshHeader(new TwoLevelHeader(this));//二级刷新头
//        refreshLayout.setRefreshFooter(BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale)) //脉冲尾
        tuisongRefreshLayout.setOnRefreshListener { refreshlayout ->
            refreshlayout.finishRefresh(1000 /*,false*/) //传入false表示刷新失败
        }
        tuisongRefreshLayout.setOnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(1000 /*,false*/) //传入false表示加载失败
        }
    }
}