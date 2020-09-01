package com.mdy.http

import okhttp3.Response

/**
 * User: maodayu
 * Date: 2020/8/28
 * Time: 下午5:47
 */
interface OnHttpResultCallback {
    fun onSuccess(result: Response)
    fun onFailed(throwable: Throwable)
}