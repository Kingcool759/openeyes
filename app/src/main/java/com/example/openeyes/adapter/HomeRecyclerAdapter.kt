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
 * @auther
 * @describe
 */
class HomeRecyclerAdapter(
    context: Context,
    dataList: ArrayList<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //上下文环境+数据源
    private val mContext: Context = context
    private val mDataList: ArrayList<Item> = dataList

    //设置ViewType用
    private val BANNER: Int = 0
    private val HOT_TYPE: Int = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == BANNER) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_banner, parent, false)
            return BannerViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_home_hottype, parent, false)
            return HotTypeViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var dataList: List<ItemX>? = null
        if (mDataList.size == 0) {
            return
        }
        if (holder is BannerViewHolder) {
            if (mDataList.get(position).type == "horizontalScrollCard") {
                if (mDataList.get(position).data.dataType == "HorizontalScrollCard") {
                    dataList = mDataList.get(position).data.itemList
                }
            }
            val layoutManager = LinearLayoutManager(mContext)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            holder.banner_rv.layoutManager = layoutManager
            holder.banner_rv.adapter = dataList?.let { HomeBannerAdapter(mContext, it) }
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(holder.banner_rv)
        } else if (holder is HotTypeViewHolder) {
            if (mDataList.size == 0) {
                return
            }
            if (mDataList.get(position).type == "specialSquareCardCollection") {
                if (mDataList.get(position).data.dataType == "ItemCollection") {
                    dataList = mDataList.get(position).data.itemList
                }
            }
            val layoutManager = GridLayoutManager(mContext, 2)
            layoutManager.orientation = GridLayoutManager.HORIZONTAL
            holder.hottype_rv.layoutManager = layoutManager
            holder.hottype_rv.adapter = HomeHotTypeAdapter(mContext, dataList)
        }
    }

    override fun getItemCount(): Int = 2

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return BANNER
        } else {
            return HOT_TYPE
        }
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner_rv: RecyclerView = itemView.findViewById(R.id.banner_recycler)
    }

    inner class HotTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hottype_rv: RecyclerView = itemView.findViewById(R.id.home_hottype_recycler)
    }
}