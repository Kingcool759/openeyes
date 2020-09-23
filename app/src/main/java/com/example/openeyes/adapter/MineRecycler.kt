package com.example.openeyes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openeyes.R

/**
 * @data on 2020/9/23 5:37 PM
 * @auther
 * @describe
 */
class MineRecycler(textList: ArrayList<String>) : RecyclerView.Adapter<MineRecycler.MyViewHolder>() {

    private val textList:ArrayList<String>? = textList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MineRecycler.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_mine_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = textList!!.size

    override fun onBindViewHolder(holder: MineRecycler.MyViewHolder, position: Int) {
        val textpot = textList?.get(position)
        holder.title.text = textpot
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.mine_title)
    }
}