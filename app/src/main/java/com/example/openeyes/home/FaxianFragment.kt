package com.example.openeyes.home

import android.os.Bundle
import android.util.Log
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
import kotlinx.android.synthetic.main.faxian_fragment.*

class FaxianFragment : Fragment() {
    private lateinit var binding: FaxianFragmentBinding
    private lateinit var viewModel: FaxianViewModel
    private var dataList: ArrayList<Item> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //使用databinding绑定viewmodel
        binding = DataBindingUtil.inflate(inflater, R.layout.faxian_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(FaxianViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getfaxianList()
        getDataCallback()
        setHomeRecycler()

    }

    private fun getDataCallback() {
        viewModel.mHomeList.observe(viewLifecycleOwner, Observer {
            dataList.addAll(it)
            home_recycler.adapter?.notifyDataSetChanged()
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
}