package com.example.openeyes.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @data on 2020/9/3 10:51 AM
 * @auther
 * @describe java 时间戳/字符串 之间转换
 */
class DateUtil {
    private var sf: SimpleDateFormat? = null

    // 将时间戳转成字符串
    fun getDateToString(time: Long): String {
        val d = Date(time)
        sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sf!!.format(d)
    }

    //获取当前时间
    val currentDate: String
        get() {
            val d = Date()
            sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sf!!.format(d)
        }

    //将字符串转换为时间戳
    fun getStringToDate(time: String?): Long {
        sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var date = Date()
        try {
            date = sf!!.parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date.time
    }

    //直接获取当前时间戳
    val timeStamp: String
        get() {
            val currentDate = currentDate
            sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var date = Date()
            try {
                date = sf!!.parse(currentDate)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return date.time.toString()
        }
}