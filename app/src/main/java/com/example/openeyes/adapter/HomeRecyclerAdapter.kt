package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.example.openeyes.R
import com.example.openeyes.databean.Item
import com.example.openeyes.databean.ItemX

/**
 * @data on 2020/9/27 2:53 PM
 * @auther armStrong
 * @describe 发现页面：RecyclerView实现多ViewType布局
 */
class HomeRecyclerAdapter(private val mContext: Context, private val mDataList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_banner, parent, false)
            BannerViewHolder(view)
        } else if (viewType == 1){
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_item_recycler, parent, false)
            HotTypeViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_item_recycler, parent, false)
            SubjectViewHolder(view)
        }
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var dataList: List<ItemX> = ArrayList()
        if (holder is BannerViewHolder) {
            if (mDataList[position].type == "horizontalScrollCard") {
                if (mDataList[position].data.dataType == "HorizontalScrollCard") {
                    dataList = mDataList[position].data.itemList
                }
            }
            val layoutManager = LinearLayoutManager(mContext)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            holder.banner_rv.layoutManager = layoutManager
            holder.banner_rv.adapter = dataList?.let { HomeBannerAdapter(mContext, it) }
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(holder.banner_rv)
        } else if (holder is HotTypeViewHolder) {
            if (mDataList[position].type == "specialSquareCardCollection") {
                val data = mDataList[position].data
                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                holder.hottype_rv.layoutManager = layoutManager
                holder.hottype_rv.adapter = HomeHotTypeAdapter(mContext, data)
            }
        } else if(holder is SubjectViewHolder){
            if (mDataList[position].type == "columnCardList") {
                val data = mDataList[position].data
                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                holder.subject_rv.layoutManager = layoutManager
                holder.subject_rv.adapter = HomeSubjectAdapter(mContext, data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position;
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner_rv: RecyclerView = itemView.findViewById(R.id.banner_recycler)
    }

    inner class HotTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hottype_rv: RecyclerView = itemView.findViewById(R.id.home_item_recycler)
    }

    inner class SubjectViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val subject_rv: RecyclerView = itemView.findViewById(R.id.home_item_recycler)
    }
}