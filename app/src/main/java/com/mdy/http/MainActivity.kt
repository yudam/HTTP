package com.mdy.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nvm = ViewModelProvider(this).get(NetViewModel::class.java)
        Log.e("MDY", "Thread  1 = " + Thread.currentThread().name)

        nvm.getData(object : OnHttpResultCallback {
            override fun onSuccess(result: Response) {
                Log.e("MDY", "Thread 2 = " + Thread.currentThread().name)

                Log.e("MDY", "onSuccess=" + result.body!!.string())
            }

            override fun onFailed(throwable: Throwable) {
                Log.e("MDY", "onFailed=" + throwable.message)
            }

        })

    }
}