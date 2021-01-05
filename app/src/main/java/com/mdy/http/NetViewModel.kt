package com.mdy.http

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException
import java.net.Proxy
import java.net.ProxySelector
import java.util.concurrent.TimeUnit

/**
 * User: maodayu
 * Date: 2020/8/28
 * Time: 下午2:59
 */
class NetViewModel constructor(application: Application)  : AndroidViewModel(application) {

    val okHttpClient = OkHttpClient.Builder()
        .writeTimeout(5000, TimeUnit.MILLISECONDS)
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(10000, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)  //是否允许失败重试
        .followRedirects(true)  //资源Url更改时，是否允许重定向
        .followSslRedirects(true) //重定向时，请求协议被由HTTP重定向为HTTPS，或者 反之是否允许重定向，默认为true
        .proxy(Proxy.NO_PROXY)
        .proxySelector(ProxySelector.getDefault())
        .dispatcher(Dispatcher())
        .cookieJar(CookieJar.NO_COOKIES)
        .cache(Cache(application.cacheDir,10*1024*1024))
        .build()

    val header = Headers.Builder()
        .build()

    val cacheCOntrol = CacheControl.Builder()
        .noCache()
        .noStore()
        .onlyIfCached()
        .maxAge(2,TimeUnit.SECONDS)
        .maxStale(2,TimeUnit.SECONDS)
        .minFresh(2,TimeUnit.SECONDS)
        .build()


    val request: Request = Request.Builder()
        .url("https://www.wanandroid.com/article/list/0/json")
        .method("GET", null)
        .tag("")
        .headers(header)
        .cacheControl(CacheControl.FORCE_CACHE)
        .cacheControl(cacheCOntrol)
        .build()

    val call = okHttpClient.newCall(request)

    /**************************************************************/

    private val request1 :Request = Request.Builder()
        .url("https://www.wanandroid.com/article/list/0/json")
        .method("GET",null)
        .cacheControl(CacheControl.Builder().noCache().build())
        .build()

    private val request2 :Request = Request.Builder()
        .url("https://www.wanandroid.com/article/list/0/json")
        .method("GET",null)
        .cacheControl(CacheControl.Builder().onlyIfCached().build())
        .build()

    private val okhttpClient1:OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(application.cacheDir,10*1024*1024))
        .build()

    fun getData(callback:OnHttpResultCallback) {
        viewModelScope.launch {
            Log.i("MDY", "Thread-name-1："+Thread.currentThread().name)
            okhttpClient1.newCall(request1).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback.onFailed(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    callback.onSuccess(response)
                }

            })
        }
    }


    fun getData2(callback:OnHttpResultCallback) {
        viewModelScope.launch {
            Log.i("MDY", "Thread-name-1："+Thread.currentThread().name)
            okhttpClient1.newCall(request2).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback.onFailed(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    callback.onSuccess(response)
                }

            })
        }
    }

}