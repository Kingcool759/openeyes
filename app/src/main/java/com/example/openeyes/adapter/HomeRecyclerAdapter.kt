package com.example.openeyes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.example.openeyes.R
import kotlinx.android.synthetic.main.faxian_fragment.*

/**
 * @data on 2020/9/27 2:53 PM
 * @auther
 * @describe
 */
class HomeRecyclerAdapter(
    context: Context,
    bannerUrlList: ArrayList<String>,
    imgUrlList: ArrayList<String>,
    textsList: ArrayList<String>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mContext: Context = context
    private val bannerList: ArrayList<String> =bannerUrlList
    private val imgUriList: ArrayList<String> = imgUrlList
    private val textList: ArrayList<String> = textsList

    //设置ViewType用
    private val BANNER: Int = 0
//    private val HOT_TYPE_TITLE: Int = 1
    private val HOT_TYPE: Int = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == BANNER){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_banner, parent, false)
            return BannerViewHolder(view)
        }else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_hottype, parent, false)
            return HotTypeViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BannerViewHolder){
            val layoutManager = LinearLayoutManager(mContext)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            holder.banner_rv.layoutManager = layoutManager
            holder.banner_rv.adapter = HomeBannerAdapter(mContext,bannerList)
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(holder.banner_rv)
        }else if(holder is HotTypeViewHolder){
            val layoutManager = GridLayoutManager(mContext,2)
            layoutManager.orientation = GridLayoutManager.HORIZONTAL
            holder.hottype_rv.layoutManager = layoutManager
            holder.hottype_rv.adapter = HomeHotTypeAdapter(mContext,imgUriList,textList)
        }
    }

    override fun getItemCount(): Int = 2

    override fun getItemViewType(position: Int): Int {
        if ( position == 0){
            return BANNER
        }else {
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