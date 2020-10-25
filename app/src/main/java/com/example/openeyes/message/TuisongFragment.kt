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
}