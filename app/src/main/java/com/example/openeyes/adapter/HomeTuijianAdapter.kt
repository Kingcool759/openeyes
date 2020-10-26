package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R
import com.example.openeyes.databean.ItemX
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @data on 2020/10/26 9:57 AM
 * @auther
 * @describe
 */
class HomeTuijianAdapter (
    val context: Context,
    val dataList: List<ItemX>
) : RecyclerView.Adapter<HomeTuijianAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeTuijianAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_banner_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: HomeTuijianAdapter.MyViewHolder, position: Int) {
        var url: String? = null
        if (dataList[position].type == "banner") {
            url = dataList[position].data.image
        }
        if (context != null) {
            Glide.with(context).load(url).into(holder.banner_iv)
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner_iv: RoundedImageView = itemView.findViewById(R.id.banner_img)
    }
}