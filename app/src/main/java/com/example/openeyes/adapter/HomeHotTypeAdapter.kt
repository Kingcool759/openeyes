package com.example.openeyes.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R
import com.example.openeyes.databean.Item
import com.example.openeyes.databean.ItemX
import kotlin.time.days

/**
 * @data on 2020/9/28 10:44 AM
 * @auther
 * @describe
 */
class HomeHotTypeAdapter(context: Context, data: List<ItemX>?) :
    RecyclerView.Adapter<HomeHotTypeAdapter.MyViewHolder>() {
    private val context: Context? = context
    private val dataList: List<ItemX>? = data

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeHotTypeAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_home_hottype_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: HomeHotTypeAdapter.MyViewHolder, position: Int) {
        var url: String? = null
        var title: String? = null
        if (dataList?.get(position)?.type == "squareCardOfCategory") {
            url = dataList?.get(position).data.image
            title = dataList.get(position).data.title
        }
        if (context != null) {
            Glide.with(context).load(url).into(holder.hottype_iv)
        }
        holder.hottype_tv.text = title
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hottype_iv: ImageView = itemView.findViewById(R.id.home_hot_iv)
        val hottype_tv: TextView = itemView.findViewById(R.id.home_hot_tv)
    }
}