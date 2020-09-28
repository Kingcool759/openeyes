package com.example.openeyes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openeyes.R
import com.example.openeyes.adapter.HomeRecyclerAdapter
import kotlinx.android.synthetic.main.faxian_fragment.*

class FaxianFragment : Fragment() {
    private lateinit var viewModel: FaxianViewModel
    private var bannerUrlList: ArrayList<String> = ArrayList()
    private var imageUrlList: ArrayList<String> = ArrayList()
    private var textList: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.faxian_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FaxianViewModel::class.java)

        initData()
        setHomeRecycler()

    }
    //数据初始化
    private fun initData(){
        //循环加载数据
        for (index in 1..16){
            bannerUrlList.add("http://img.kaiyanapp.com/080ae71a70b83f67b515209f85f90d56.jpeg?imageMogr2/quality/60/format/jpg")
            imageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601266292514&di=95c75c1bdc303eaca8cb525ee5d596fa&imgtype=0&src=http%3A%2F%2Fp.ssl.qhimg.com%2Fbdr%2F__85%2Fd%2F_open360%2Fcar0911%2F10.jpg")
            textList.add("#广告")
        }
    }
    //设置recycler
    private fun setHomeRecycler(){
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        home_recycler.layoutManager = layoutManager
        home_recycler.adapter =
            context?.let { HomeRecyclerAdapter(it,bannerUrlList,imageUrlList,textList) }
    }
}