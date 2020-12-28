package com.sangame.klib.pretent

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 17:53
 */
interface Interceptor {
     fun intercept(chain: Chain):String
}