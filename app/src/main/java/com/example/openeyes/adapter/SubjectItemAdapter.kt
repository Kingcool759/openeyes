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
 * @data on 2020/10/23 2:36 PM
 * @auther
 * @describe
 */
class SubjectItemAdapter(val context: Context, val itemList :List<ItemX> = ArrayList()) :
    RecyclerView.Adapter<SubjectItemAdapter.SubjectItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectItemAdapter.SubjectItemViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_home_subject_item, parent, false)
        return SubjectItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: SubjectItemViewHolder, position: Int) {
        val url = itemList[position].data.image
        val title = itemList[position].data.title
        Glide.with(context).load(url).into(holder.subject_iv)
        holder.subject_tv.text = title
    }

    inner class SubjectItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject_iv: RoundedImageView = itemView.findViewById(R.id.home_sub_iv)
        val subject_tv: TextView = itemView.findViewById(R.id.home_sub_tv)
    }
}