package com.example.openeyes.community

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openeyes.R

class Tuijian2Fragment : Fragment() {

    companion object {
        fun newInstance() = Tuijian2Fragment()
    }

    private lateinit var viewModel: Tuijian2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tuijian2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(Tuijian2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}