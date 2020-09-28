//package com.example.openeyes.api
//
//import android.accessibilityservice.GestureDescription
//import android.os.Build
//import androidx.annotation.RequiresApi
//import com.google.gson.Gson
//import com.google.gson.GsonBuilder
//import io.reactivex.schedulers.Schedulers
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import java.security.KeyManagementException
//import java.security.NoSuchAlgorithmException
//import java.security.SecureRandom
//import java.security.cert.CertificateException
//import java.security.cert.X509Certificate
//import javax.net.ssl.*
//
///**
// * @data on 2020/9/27 2:35 PM
// * @auther
// * @describe
// */
//class NetworkPortal {
//    //网络请求
//    private var retrofit: Retrofit? = null
//
//    private var mInstance: NetworkPortal? = null
//
//    private var mGson: Gson? = null
//
//    //单例模式
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun getInstance(): NetworkPortal? {
//        if (null == mInstance) {
//            mInstance = NetworkPortal()
//        }
//        return mInstance
//    }
//
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun NetworkPortal(): NetworkPortal? {
//        mGson = GsonBuilder()
//            .create()
//        val builder: OkHttpClient.Builder = getDefaultBuilder()
//        builder.retryOnConnectionFailure(false)
//        retrofit = GestureDescription.Builder()
//            .baseUrl(AppApi.BaseURL)
//            .client(builder.build())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .addConverterFactory(GsonConverterFactory.create(mGson))
//            .build()
//    }
//
//    private fun getDefaultBuilder(): OkHttpClient.Builder {
//        // 创建一个OkHttpClient
//        val builder: OkHttpClient.Builder = GestureDescription.Builder()
//        builder.hostnameVerifier(createHostnameVerifier())
//        builder.sslSocketFactory(createSSlSocket(), object : X509TrustManager {
//            @Throws(CertificateException::class)
//            override fun checkClientTrusted(
//                x509Certificates: Array<X509Certificate>,
//                s: String
//            ) {
//            }
//
//            @Throws(CertificateException::class)
//            override fun checkServerTrusted(
//                x509Certificates: Array<X509Certificate>,
//                s: String
//            ) {
//            }
//
//            override fun getAcceptedIssuers(): Array<X509Certificate?> {
//                return arrayOfNulls(0)
//            }
//        })
//        return builder
//    }
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun buildRetrofit(url: String): Retrofit? {
//        val builder: OkHttpClient.Builder = getDefaultBuilder()
//        builder.retryOnConnectionFailure(false)
//        return GestureDescription.Builder()
//            .baseUrl(url)
//            .client(builder.build())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .addConverterFactory(GsonConverterFactory.create(mGson))
//            .build()
//    }
//
//    /**
//     * @return 指定service实例
//     */
//    fun <T> getService(clazz: Class<T>?): T? {
//        return getService(clazz, "")
//    }
//
//    /**
//     * @return 指定service实例
//     */
//    fun <T> getService(clazz: Class<T>?, baseURL: String): T? {
//        var service: T? = null
//        if (baseURL.isEmpty()) {
//            service = NetworkPortal.getInstance().buildRetrofit(AppApi.BaseURL).create(clazz)
//        }
//        return service
//    }
//
//    //抓包用，Https(默认只能抓到http,所以需要用代码设置)
//    private fun createHostnameVerifier(): HostnameVerifier? {
//        return HostnameVerifier { s, sslSession -> true }
//    }
//
//    private fun createSSlSocket(): SSLSocketFactory? {
//        var ssl: SSLContext? = null
//        try {
//            ssl = SSLContext.getInstance("SSL")
//            ssl.init(
//                null,
//                arrayOf<TrustManager>(object : X509TrustManager {
//                    @Throws(CertificateException::class)
//                    override fun checkClientTrusted(
//                        x509Certificates: Array<X509Certificate>,
//                        s: String
//                    ) {
//                    }
//
//                    @Throws(CertificateException::class)
//                    override fun checkServerTrusted(
//                        x509Certificates: Array<X509Certificate>,
//                        s: String
//                    ) {
//                    }
//
//                    override fun getAcceptedIssuers(): Array<X509Certificate?> {
//                        return arrayOfNulls(0)
//                    }
//                }),
//                SecureRandom()
//            )
//            return ssl.socketFactory
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        } catch (e: KeyManagementException) {
//            e.printStackTrace()
//        }
//        return null
//    }
//}