package com.mdy.http.intercept

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.RealInterceptorChain

/**
 * User: maodayu
 * Date: 2020/9/8
 * Time: 11:20
 */
class ProcessBarInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val realChain = chain as RealInterceptorChain
        val request = chain.request()
        val response = realChain.proceed(request)
        return response
    }
}