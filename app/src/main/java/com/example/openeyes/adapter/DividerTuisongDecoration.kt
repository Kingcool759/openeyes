package com.example.openeyes.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.openeyes.R

/**
 * @data on 2020/10/26 10:57 AM
 * @auther armStrong
 * @describe 通知-推送（特殊分割线）
 */
class DividerTuisongDecoration(context: Context) : RecyclerView.ItemDecoration() {
    //分割线
    private val dividerHeight: Int

    //左边距设置
    private val maginLeft: Int

    //右边距设置
    private val maginRight: Int

    //上边距设置
    private val maginTop: Int

    //定制分割线颜色
    private val dividerPaint: Paint
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = dividerHeight
    }

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.onDraw(c, parent, state)
        //画item的布局
        val childCount = parent.childCount
        for (i in 0 until childCount) {  //最后一个也设置线，不要则 childCount-1
            val view = parent.getChildAt(i)
            val startx = parent.paddingLeft + maginLeft.toFloat()
            val starty = view.bottom.toFloat()
            val stopx = startx + view.width
            val stopy = view.bottom.toFloat()
            c.drawLine(startx, starty, stopx, stopy, dividerPaint)
        }
    }

    init {
        dividerPaint = Paint()
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
        dividerPaint.color = context.resources.getColor(R.color.dimgray) //暗灰色
        maginTop = context.resources.getDimensionPixelSize(R.dimen.margin_top)
        maginLeft = context.resources.getDimensionPixelSize(R.dimen.margin_left)
        maginRight = context.resources.getDimensionPixelSize(R.dimen.margin_right)
    }
}