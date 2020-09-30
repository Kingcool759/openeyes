package com.example.openeyes.tools

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @data on 2020/9/29 3:07 PM
 * @auther
 * @describe
 */

class HttpLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String?) {
        if (message != null) {
            Log.d("HttpLogInfo===>>>", message)
        } //okHttp的详细日志会打印出来
    }
}
