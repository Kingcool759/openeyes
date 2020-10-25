package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R
import com.example.openeyes.databean.Data
import com.example.openeyes.databean.ItemX
import com.example.openeyes.databean.Message
import com.example.openeyes.utils.DateUtil
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @data on 2020/10/25 4:37 PM
 * @auther
 * @describe
 */
class MessageRecyclerAdapter(val context: Context, val itemList :List<Message> = ArrayList()) :
    RecyclerView.Adapter<MessageRecyclerAdapter.MessageItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageRecyclerAdapter.MessageItemViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_message_tuisong_item, parent, false)
        return MessageItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MessageItemViewHolder, position: Int) {
        holder.message_title.text  = itemList[position].title
        holder.message_time.text = DateUtil().getDateToString(itemList[position].date)
        holder.message_content.text = itemList[position].content
    }

    inner class MessageItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message_title: TextView = itemView.findViewById(R.id.messageTitle)
        val message_time: TextView = itemView.findViewById(R.id.messageTime)
        val message_content: TextView = itemView.findViewById(R.id.messageContent)
    }
}