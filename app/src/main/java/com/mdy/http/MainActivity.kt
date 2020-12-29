package com.mdy.http

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import okhttp3.Response
import java.util.*
import kotlin.collections.ArrayDeque

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:NetViewModel
    lateinit var tv_content:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = NetViewModel(application)
        tv_content = findViewById(R.id.tv_content)
        val scope = CoroutineScope(Dispatchers.Main+ Job())
        val job = scope.launch {  }
        job.cancel()
        scope.cancel()
        scope.async {  }
    }


    fun sendHttp(view: View) {
        viewModel.getData(object : OnHttpResultCallback {
            override fun onSuccess(result: Response) {
                runOnUiThread{
                    tv_content.text = result.body?.string() ?: "this is null"
                }
            }

            override fun onFailed(throwable: Throwable) {
            }
        })
    }

    fun clearHttp(view: View){
        tv_content.text = ""
    }
}