package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openeyes.R
import com.example.openeyes.databean.Item
import com.makeramen.roundedimageview.RoundedImageView
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @data on 2020/10/26 10:21 AM
 * @auther
 * @describe
 */
class HomeRibaoAdapter(
    val context: Context,
    val dataList: List<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == 0 || viewType == 8) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_jingxuan_title_item, parent, false)
            TitleViewHolder(view)
        } else if (viewType == 6 ) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_zixun_title_item, parent, false)
            ZixunViewHolder(view)
        } else if (viewType == 7) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_zixun_item, parent, false)
            InForViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_jingxuan_item, parent, false)
            JingxuanViewHolder(view)
        }
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleViewHolder) {
            if (dataList[position].type == "textCard") {
                holder.ribao_title.text = dataList[position].data.text
            }
        } else if (holder is ZixunViewHolder) {
            if (dataList[position].type == "textCard") {
                holder.zixunTitle.text = dataList[position].data.text
                holder.zixunWangqi.text = dataList[position].data.rightText
            }
        } else if (holder is InForViewHolder) {
            if (dataList[position].type == "informationCard") {
                val layoutManager = LinearLayoutManager(context)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                holder.zixunRecyclerView.layoutManager = layoutManager
                holder.zixunRecyclerView.adapter =
                    HomeRibaoZixunAdapter(context, dataList[position].data.titleList)
            }
        } else if (holder is JingxuanViewHolder) {
            if (dataList[position].type == "followCard") {
                Glide.with(context).load(dataList[position].data.content.data.cover.feed).into(holder.ribao_feed_image)
                Glide.with(context).load(dataList[position].data.header.icon).into(holder.ribao_header_icon)
                holder.ribao_header_title.text = dataList[position].data.header.title
                holder.ribao_header_description.text = dataList[position].data.header.description
            }
        }
    }

    //今日开眼精选
    inner class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ribao_title: TextView = itemView.findViewById(R.id.ribao_title)
    }

    //每日资讯头
    inner class ZixunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zixunTitle: TextView = itemView.findViewById(R.id.zixun_title)
        val zixunWangqi: TextView = itemView.findViewById(R.id.zixun_wangqi)
    }

    //每日资讯-信息体
    inner class InForViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zixunRecyclerView: RecyclerView = itemView.findViewById(R.id.zixunRecycler)
    }

    //精选体
    inner class JingxuanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ribao_feed_image: RoundedImageView = itemView.findViewById(R.id.ribao_feed_image)
        val ribao_header_icon: CircleImageView = itemView.findViewById(R.id.ribao_header_icon)
        val ribao_header_title: TextView = itemView.findViewById(R.id.ribao_header_title)
        val ribao_header_description: TextView =
            itemView.findViewById(R.id.ribao_header_description)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}