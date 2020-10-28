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
import com.example.openeyes.databean.Item
import com.example.openeyes.databean.ItemX
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @data on 2020/9/27 2:53 PM
 * @auther armStrong
 * @describe 发现页面：RecyclerView实现多ViewType布局
 */
class HomeRecyclerAdapter(private val mContext: Context, private val mDataList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val snapHelper: SnapHelper = PagerSnapHelper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_banner, parent, false)
            BannerViewHolder(view)
        } else if (viewType == 1) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_recycler, parent, false)
            HotTypeViewHolder(view)
        } else if (viewType == 2) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_recycler, parent, false)
            SubjectViewHolder(view)
        } else if (viewType == 3 || viewType == 5 || viewType == 11) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.topictitle_home_recycler_item, parent, false)
            TypeTitleViewHolder(view)
        } else if (viewType == 4) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.openeyes_special_banner_image, parent, false)
            SpecialBannerViewHolder(view)
        } else if (viewType == 6 || viewType == 7 || viewType == 8 || viewType == 9 || viewType == 10) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_weektop_content_item, parent, false)
            WeekTopViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_topic_content_item, parent, false)
            TopicContentViewHolder(view)
        }
    }

    override fun getItemCount(): Int = mDataList.size

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
            //解决RecyclerView中用SnapHelper抛出异常：java.lang.IllegalStateException: An instance of OnFlingListener already set.
            snapHelper.attachToRecyclerView(holder.banner_rv)
        } else if (holder is HotTypeViewHolder) {
            if (mDataList[position].type == "specialSquareCardCollection") {
                val data = mDataList[position].data
                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                holder.hottype_rv.layoutManager = layoutManager
                holder.hottype_rv.adapter = HomeHotTypeAdapter(mContext, data)
            }
        } else if (holder is SubjectViewHolder) {
            if (mDataList[position].type == "columnCardList") {
                val data = mDataList[position].data
                val layoutManager = LinearLayoutManager(mContext)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                holder.subject_rv.layoutManager = layoutManager
                holder.subject_rv.adapter = HomeSubjectAdapter(mContext, data)
            }
        } else if (holder is TypeTitleViewHolder) {
            if (mDataList[position].type == "textCard") {
                holder.home_type_title.text = mDataList[position].data.text
                holder.home_type_all.text = mDataList[position].data.rightText
            }
        } else if (holder is SpecialBannerViewHolder) {
            if (mDataList[position].type == "banner") {
                val url = mDataList[position].data.image
                Glide.with(mContext).load(url).into(holder.special_banner)
            }
        } else if (holder is WeekTopViewHolder) {
            if (mDataList[position].type == "videoSmallCard") {
                val url = mDataList[position].data.cover.feed
                Glide.with(mContext).load(url).into(holder.weekTop_image)
                holder.weekTop_title.text = mDataList[position].data.title
                holder.weekTop_category.text = mDataList[position].data.category
            }
        } else if (holder is TopicContentViewHolder) {
            if (mDataList[position].type == "briefCard") {
                val url = mDataList[position].data.icon
                Glide.with(mContext).load(url).into(holder.topicImage)
                holder.topicTitle.text = mDataList[position].data.title
                holder.topicDes.text = mDataList[position].data.description
                holder.topicCare.setOnClickListener {
                    holder.topicCare.isSelected = !(holder.topicCare.isSelected)
                    if (holder.topicCare.text == "已关注"){
                        holder.topicCare.text = "加关注"
                    }else{
                        holder.topicCare.text = "已关注"
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position;
    }

    //  banner-0
    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner_rv: RecyclerView = itemView.findViewById(R.id.banner_recycler)
    }

    //  热门分类-1
    inner class HotTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hottype_rv: RecyclerView = itemView.findViewById(R.id.home_item_recycler)
    }

    //  专题策划-2
    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject_rv: RecyclerView = itemView.findViewById(R.id.home_item_recycler)
    }

    //  本周榜单-title-3 、开眼专题-title-5 和 推荐主题-title-12
    inner class TypeTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val home_type_title: TextView = itemView.findViewById(R.id.home_type_title)
        val home_type_all: TextView = itemView.findViewById(R.id.home_type_all)
    }

    //  开眼专栏-4
    inner class SpecialBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val special_banner: RoundedImageView = itemView.findViewById(R.id.specialBanner)
    }

    //  本周榜单-4->8
    inner class WeekTopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekTop_image: RoundedImageView = itemView.findViewById(R.id.weekTop_image)
        val weekTop_title: TextView = itemView.findViewById(R.id.weekTop_title)
        val weekTop_category: TextView = itemView.findViewById(R.id.weekTop_category)
    }

    //  推荐主题-10-20
    inner class TopicContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicImage: RoundedImageView = itemView.findViewById(R.id.topicImage)
        val topicTitle: TextView = itemView.findViewById(R.id.topicTitle)
        val topicDes: TextView = itemView.findViewById(R.id.topicDescription)
        val topicCare: TextView = itemView.findViewById(R.id.tv_care)
    }
}