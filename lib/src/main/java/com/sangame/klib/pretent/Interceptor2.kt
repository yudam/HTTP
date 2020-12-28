package com.sangame.klib.pretent

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 18:33
 */
class Interceptor2 : Interceptor {
    override fun intercept(chain: Chain): String {
        val realInterceptor = chain as RealInterceptor
        realInterceptor.text = realInterceptor.text + "_2"
        return realInterceptor.process(realInterceptor.text)
    }
}