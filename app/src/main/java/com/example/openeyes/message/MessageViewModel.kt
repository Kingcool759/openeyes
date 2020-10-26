package com.example.openeyes.message

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openeyes.api.ApiCallback
import com.example.openeyes.api.AppApiService
import com.example.openeyes.api.NetworkPortal
import com.example.openeyes.databean.Message
import com.example.openeyes.databean.MessageDataBean
import retrofit2.Call
import retrofit2.Response

class MessageViewModel : ViewModel() {
    //推送
    val mMessageTuisongList: MutableLiveData<List<Message>> = MutableLiveData()

    fun getTuisongList(){
        NetworkPortal.getService(AppApiService::class.java)?.gettuisongDataList()
            ?.enqueue(object : ApiCallback<MessageDataBean?>() {
                override fun onSuccessful(
                    call: Call<MessageDataBean?>,
                    response: Response<MessageDataBean?>
                ) {
                    Log.d("onSuccessful", "请求成功了！")
                    if (response.body() == null) {
                        return
                    } else {
                        mMessageTuisongList.value = (response.body()!!.messageList)
                    }
                }

                override fun onFail(message: String?) {
                    Log.d("onFail", "啊哦～请求失败了！")
                }
            })
    }
}