package com.example.openeyes.api

import com.example.openeyes.databean.HomeDataBean
import com.example.openeyes.databean.MessageDataBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * @data on 2020/9/27 2:35 PM
 * @auther
 * @describe
 */
interface AppApiService {
    /**
     * 首页
     */

    @GET(AppApi.home_faxian_List)
    fun getfaxianDataList(): Call<HomeDataBean>

    @GET(AppApi.home_tuijian_List)
    fun gettuijianDataList(): Call<HomeDataBean>

    @GET(AppApi.home_ribao_List)
    fun getribaoDataList(): Call<HomeDataBean>

    /**
     * 通知
     */

    @GET(AppApi.message_tuisong_List)
    fun gettuisongDataList(): Call<MessageDataBean>
}