package com.mdy.http

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Response

class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    lateinit var viewModel: NetViewModel
    lateinit var tv_content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = NetViewModel(application)
        tv_content = findViewById(R.id.tv_content)
    }

    fun sendHttp(view: View) {
        viewModel.getData(object : OnHttpResultCallback {
            override fun onSuccess(result: Response) {
                runOnUiThread {
                    tv_content.setText(result.toString())
                }
            }

            override fun onFailed(throwable: Throwable) {
                runOnUiThread {
                    tv_content.setText(throwable.message)
                }
            }
        })
    }

    fun clearHttp(view: View) {
        tv_content.text = ""
        viewModel.getData2(object : OnHttpResultCallback {
            override fun onSuccess(result: Response) {
                runOnUiThread {
                    tv_content.setText(result.toString())
                }
            }

            override fun onFailed(throwable: Throwable) {
                runOnUiThread {
                    tv_content.setText(throwable.message)
                }
            }
        })
    }
}