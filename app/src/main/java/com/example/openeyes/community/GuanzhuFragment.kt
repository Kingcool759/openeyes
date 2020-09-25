package com.example.openeyes.community

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openeyes.R

class GuanzhuFragment : Fragment() {

    companion object {
        fun newInstance() = GuanzhuFragment()
    }

    private lateinit var viewModel: GuanzhuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.guanzhu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GuanzhuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}