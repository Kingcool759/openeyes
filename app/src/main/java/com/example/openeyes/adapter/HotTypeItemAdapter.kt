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
import com.example.openeyes.databean.Data
import com.example.openeyes.databean.ItemX
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @data on 2020/10/23 10:46 AM
 * @auther armStrong
 * @describe 热门分类下：广告等多个分类
 */
class HotTypeItemAdapter(val context: Context, val itemList :List<ItemX> = ArrayList()) :
    RecyclerView.Adapter<HotTypeItemAdapter.TypeItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotTypeItemAdapter.TypeItemViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_home_hottype_item, parent, false)
            return TypeItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: TypeItemViewHolder, position: Int) {
        val url = itemList[position].data.image
        val title = itemList[position].data.title
        Glide.with(context).load(url).into(holder.hottype_iv)
        holder.hottype_tv.text = title
    }

    inner class TypeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hottype_iv: RoundedImageView = itemView.findViewById(R.id.home_hot_iv)
        val hottype_tv: TextView = itemView.findViewById(R.id.home_hot_tv)
    }
}