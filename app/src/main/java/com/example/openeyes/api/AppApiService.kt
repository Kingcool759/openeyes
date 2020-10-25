package com.example.openeyes.api

import com.example.openeyes.databean.HomeFaxianListRes
import com.example.openeyes.databean.MessageTuisongListRes
import retrofit2.Call
import retrofit2.http.GET

/**
 * @data on 2020/9/27 2:35 PM
 * @auther
 * @describe
 */
interface AppApiService {
    /**
     * 获取体系-导航数据
     */
//    @GET(AppApi.homt_hotList)
//    fun getHotDataList(): Call<HomeHotListRes>
    @GET(AppApi.home_faxian_List)
    fun getfaxianDataList(): Call<HomeFaxianListRes>

    @GET(AppApi.message_tuisong_List)
    fun gettuisongDataList(): Call<MessageTuisongListRes>
}