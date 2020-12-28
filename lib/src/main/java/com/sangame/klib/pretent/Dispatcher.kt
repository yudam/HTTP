package com.sangame.klib.pretent

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 18:35
 */

fun main(array: Array<String>) {

    val interceptors = mutableListOf<Interceptor>()
    interceptors+=Interceptor1()
    interceptors+=Interceptor2()

    val text = "maodayu"
    val realInterceptor = RealInterceptor(interceptors,0,text)
    val result = realInterceptor.process(text)

    println("result =$result")

    /**
     * 责任链模式中需要一个调度器来调度每一条拦截器，
     *
     *
     */
}
