package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R

/**
 * @data on 2020/9/28 10:45 AM
 * @auther
 * @describe
 */
class HomeBannerAdapter(context: Context,bannerList: ArrayList<String>) : RecyclerView.Adapter<HomeBannerAdapter.MyViewHolder>() {
    private val context: Context? = context
    private val bannerList: ArrayList<String>? = bannerList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_banner_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = bannerList!!.size

    override fun onBindViewHolder(holder: HomeBannerAdapter.MyViewHolder, position: Int) {
        val url = bannerList?.get(position)
        if (context != null) {
            Glide.with(context).load(url).into(holder.banner_iv)
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner_iv: ImageView = itemView.findViewById(R.id.banner_img)
    }
}