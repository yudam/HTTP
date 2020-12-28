package com.mdy.http.request

import okhttp3.HttpUrl

/**
 * User: maodayu
 * Date: 2020/9/27
 * Time: 11:13
 */
object RequestWrapper {

    // https://www.wanandroid.com/article/list/0/json
    val httpUrl = HttpUrl.Builder()
        .scheme("https")
        .host("www.wanandroid.com")
        .addPathSegment("article")
        .addPathSegment("list")
        .addPathSegments("0/json")
        .build()

}