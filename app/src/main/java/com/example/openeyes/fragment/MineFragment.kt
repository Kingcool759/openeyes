package com.example.openeyes.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.MineRecyclerAdapter
import com.example.openeyes.viewmodel.MineViewModel
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : Fragment() {

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.mine_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        //点击事件处理
        onClick()
    }

    private fun onClick(){
        tv_mine_care.setOnClickListener { Toast.makeText(context,"关注",Toast.LENGTH_SHORT).show() }
        tv_mine_record.setOnClickListener { Toast.makeText(context,"记录",Toast.LENGTH_SHORT).show() }
        tv_mine_message.setOnClickListener { Toast.makeText(context,"消息",Toast.LENGTH_SHORT).show() }
        tv_mine_badge.setOnClickListener { Toast.makeText(context,"徽章",Toast.LENGTH_SHORT).show() }
        tv_mine_idea.setOnClickListener { Toast.makeText(context,"意见",Toast.LENGTH_SHORT).show() }
        tv_mine_magazine.setOnClickListener { Toast.makeText(context,"投稿",Toast.LENGTH_SHORT).show() }
    }

}