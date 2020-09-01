package com.mdy.http

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * User: maodayu
 * Date: 2020/8/28
 * Time: 下午2:59
 */
public class NetViewModel  : ViewModel() {

    val okHttpClient = OkHttpClient.Builder()
        .writeTimeout(5000, TimeUnit.MILLISECONDS)
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(10000, TimeUnit.MILLISECONDS)
        .build()

    val header = Headers.Builder()
        .build()

    val request: Request = Request.Builder()
        .url("https://www.wanandroid.com/article/list/0/json")
        .get()
        .tag("")
        .headers(header)
        .build()

    val call = okHttpClient.newCall(request)

    fun getData(callback:OnHttpResultCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            call.enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback.onFailed(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    callback.onSuccess(response)
                }

            })
        }
    }


    private suspend fun get(): Response = withContext(Dispatchers.IO) {
        call.execute()
    }


}