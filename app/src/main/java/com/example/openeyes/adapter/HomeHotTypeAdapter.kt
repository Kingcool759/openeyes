package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.openeyes.R
import com.example.openeyes.databean.Data

/**
 * @data on 2020/9/28 10:44 AM
 * @auther armStrong
 * @describe
 */
class HomeHotTypeAdapter(val context: Context, private val data: Data) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.topictitle_home_recycler_item, parent, false)
            TypeTitleViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_recycler, parent, false)
            TypeItemViewHolder(view)
        }
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TypeTitleViewHolder){
            if (data.dataType == "ItemCollection"){
                holder.home_type_title.text = data.header.title
                holder.home_type_all.text = data.header.rightText
            }
        }else if (holder is TypeItemViewHolder){
            val dataList = data.itemList
            val layoutManager = GridLayoutManager(context, 2)
            layoutManager.orientation = GridLayoutManager.HORIZONTAL
            holder.recycler_home_type_hottype.layoutManager = layoutManager
            holder.recycler_home_type_hottype.adapter = HotTypeItemAdapter(context, dataList)
        }
    }

    inner class TypeTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val home_type_title:TextView = itemView.findViewById(R.id.home_type_title)
        val home_type_all:TextView = itemView.findViewById(R.id.home_type_all)
    }

    inner class TypeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recycler_home_type_hottype:RecyclerView = itemView.findViewById(R.id.home_item_recycler)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}