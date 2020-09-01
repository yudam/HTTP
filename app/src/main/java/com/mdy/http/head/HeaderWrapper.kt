package com.mdy.http.head

import okhttp3.Headers

/**
 * User: maodayu
 * Date: 2020/9/1
 * Time: 下午4:24
 */
class HeaderWrapper private constructor(private val builders: Headers.Builder) {

    companion object create {
        val wrapper = HeaderWrapper(Headers.Builder())
    }

    fun addHeader() {
        builders.add("Cache-Control","public,max-age=0,no-cache");
    }
}