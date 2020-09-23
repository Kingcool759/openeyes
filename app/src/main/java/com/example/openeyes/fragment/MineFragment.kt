package com.example.openeyes.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.MineRecycler
import com.example.openeyes.viewmodel.MineViewModel
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : Fragment() {

    private val textList = ArrayList<String>();

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        // TODO: Use the ViewModel
        //使用Recycler
        initTextList()
        val layoutManager = LinearLayoutManager(context)
        mineRecycler.layoutManager = layoutManager
        val adapter = MineRecycler(textList)
        mineRecycler.adapter = adapter
    }

    private fun initTextList(){
        textList.add(0,"我的关注")
        textList.add(1,"观察记录")
        textList.add(2,"通知开关")
        textList.add(3,"我的徽章")
        textList.add(4,"意见反馈")
        textList.add(5,"我要投稿")
    }
}