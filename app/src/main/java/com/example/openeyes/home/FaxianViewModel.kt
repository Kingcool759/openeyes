package com.example.openeyes.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openeyes.api.ApiCallback
import com.example.openeyes.api.AppApiService
import com.example.openeyes.api.NetworkPortal
import com.example.openeyes.databean.Data
import com.example.openeyes.databean.HomeFaxianListRes
import com.example.openeyes.databean.Item
import retrofit2.Call
import retrofit2.Response

public class FaxianViewModel : ViewModel() {

    //热门
    var mHomeList: MutableLiveData<List<Item>> = MutableLiveData()

    fun getfaxianList(){
        NetworkPortal.getService(AppApiService::class.java)?.getfaxianDataList()
            ?.enqueue(object : ApiCallback<HomeFaxianListRes?>() {
                override fun onSuccessful(
                    call: Call<HomeFaxianListRes?>,
                    response: Response<HomeFaxianListRes?>
                ) {
                    Log.d("onSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mHomeList.value = (response.body()!!.itemList)
                    }
                }

                override fun onFail(message: String?) {
                    Log.d("onFail", "啊哦～请求失败了！")
                }
            })
    }
}