package com.example.openeyes.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openeyes.api.ApiCallback
import com.example.openeyes.api.AppApi
import com.example.openeyes.api.AppApiService
import com.example.openeyes.api.NetworkPortal
import com.example.openeyes.databean.Card
import com.example.openeyes.databean.HomeDataBean
import com.example.openeyes.databean.HomeTuijianDataBean
import com.example.openeyes.databean.Item
import retrofit2.Call
import retrofit2.Response

public class HomeViewModel : ViewModel() {

    //发现
    var mHomeFaxianList: MutableLiveData<List<Item>> = MutableLiveData()
    //推荐
    val mHomeTuijianList:MutableLiveData<List<Card>> = MutableLiveData()
    //日报
    val mHomeRibaoList:MutableLiveData<List<Item>> = MutableLiveData()

    /**
     * 首页-发现
     */
    fun getFaxianList(){
        NetworkPortal.getService(AppApiService::class.java,AppApi.BaseURL)?.getfaxianDataList()
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
        val baseUrl = "http://api.eyepetizer.net/"
        val uid = "e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&deviceModel=TEL-AN00a&first_channel=huawei&size=1080X2400&system_version_code=29&token=91b3ff6861936532&page_type=card&page_label=recommend"
        NetworkPortal.getService(AppApiService::class.java,baseUrl)?.gettuijianDataList(uid)
            ?.enqueue(object : ApiCallback<HomeTuijianDataBean?>() {
                override fun onSuccessful(
                    call: Call<HomeTuijianDataBean?>,
                    response: Response<HomeTuijianDataBean?>
                ) {
                    Log.d("TuijianonSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mHomeTuijianList.value = (response.body()!!.result.card_list)
                    }
                }
                override fun onFail(message: String?) {
                    Log.d("TuijianonFail", "啊哦～请求失败了！")
                }
            })
    }
    /**
     * 首页-日报
     */
    fun getRibaoList(){
        NetworkPortal.getService(AppApiService::class.java,AppApi.BaseURL)?.getribaoDataList()
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