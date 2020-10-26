package com.example.openeyes.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openeyes.api.ApiCallback
import com.example.openeyes.api.AppApiService
import com.example.openeyes.api.NetworkPortal
import com.example.openeyes.databean.HomeDataBean
import com.example.openeyes.databean.Item
import retrofit2.Call
import retrofit2.Response

public class HomeViewModel : ViewModel() {

    //发现
    var mHomeFaxianList: MutableLiveData<List<Item>> = MutableLiveData()
    //推荐
    val mHomeTuijianList:MutableLiveData<List<Item>> = MutableLiveData()
    //日报
    val mHomeRibaoList:MutableLiveData<List<Item>> = MutableLiveData()

    /**
     * 首页-发现
     */
    fun getFaxianList(){
        NetworkPortal.getService(AppApiService::class.java)?.getfaxianDataList()
            ?.enqueue(object : ApiCallback<HomeDataBean?>() {
                override fun onSuccessful(
                    call: Call<HomeDataBean?>,
                    response: Response<HomeDataBean?>
                ) {
                    Log.d("onSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mHomeFaxianList.value = (response.body()!!.itemList)
                    }
                }

                override fun onFail(message: String?) {
                    Log.d("onFail", "啊哦～请求失败了！")
                }
            })
    }

    /**
     * 首页-推荐
     */
    fun getTuijianList(){
        NetworkPortal.getService(AppApiService::class.java)?.gettuijianDataList()
            ?.enqueue(object : ApiCallback<HomeDataBean?>() {
                override fun onSuccessful(
                    call: Call<HomeDataBean?>,
                    response: Response<HomeDataBean?>
                ) {
                    Log.d("onSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mHomeTuijianList.value = (response.body()!!.itemList)
                    }
                }

                override fun onFail(message: String?) {
                    Log.d("onFail", "啊哦～请求失败了！")
                }
            })
    }
    /**
     * 首页-日报
     */
    fun getRibaoList(){
        NetworkPortal.getService(AppApiService::class.java)?.getribaoDataList()
            ?.enqueue(object : ApiCallback<HomeDataBean?>() {
                override fun onSuccessful(
                    call: Call<HomeDataBean?>,
                    response: Response<HomeDataBean?>
                ) {
                    Log.d("onSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mHomeRibaoList.value = (response.body()!!.itemList)
                    }
                }

                override fun onFail(message: String?) {
                    Log.d("onFail", "啊哦～请求失败了！")
                }
            })
    }
}