package com.sangame.klib.pretent

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 18:33
 */
class Interceptor1:Interceptor {
    override fun intercept(chain: Chain): String {

        val realChain = chain as RealInterceptor
        realChain.text = realChain.text+"_1"
        return realChain.process(realChain.text)
    }
}