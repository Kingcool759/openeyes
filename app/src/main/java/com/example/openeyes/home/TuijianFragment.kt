package com.example.openeyes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.openeyes.R
import com.example.openeyes.databinding.TuijianFragmentBinding
import com.hjq.toast.ToastUtils

class TuijianFragment : Fragment() {
    private lateinit var binding: TuijianFragmentBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //使用databinding绑定viewmodel
        binding = DataBindingUtil.inflate(inflater, R.layout.tuijian_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getTuijianList()
//        ToastUtils.show("接口请求失败！原因：请求的为eyepetizer官网api接口需要验签～")
    }
}