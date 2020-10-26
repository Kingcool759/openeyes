package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R
import com.example.openeyes.databean.ItemX
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @data on 2020/10/26 3:21 PM
 * @auther
 * @describe
 */
class HomeRibaoZixunAdapter(val context: Context, val titleList :List<String> = ArrayList()) :
    RecyclerView.Adapter<HomeRibaoZixunAdapter.ZixunItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRibaoZixunAdapter.ZixunItemViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_zixun_infor_item, parent, false)
        return ZixunItemViewHolder(view)
    }

    override fun getItemCount(): Int = titleList.size

    override fun onBindViewHolder(holder: ZixunItemViewHolder, position: Int) {
        holder.zixun_inFor.text = titleList[position]
    }

    inner class ZixunItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zixun_inFor: TextView = itemView.findViewById(R.id.zixun_inFor)
    }
}