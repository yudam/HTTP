package com.sangame.klib.pretent

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 17:56
 */
class RealInterceptor( val interceptors: List<Interceptor>,
                       var index: Int,
                       var text:String) : Chain {

    private fun copy(
        interceptors: List<Interceptor> = this.interceptors,
        index: Int = this.index,
        text:String = this.text
    ) = RealInterceptor(interceptors, index,text)

    override fun process(text: String): String {
        if(index>= interceptors.size){
            return text
        }
        val interceptor = interceptors[index]
        val next = copy(interceptors, index = index + 1)
        return interceptor.intercept(next)
    }
}