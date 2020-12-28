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

    fun addCustomHeaders(){
        builders.add("Cache-Control:no-cache")
            .add("Host","www.baidu.com")
            .add("agent:1")
            .add("agent:2") //可以重复添加

        builders.set("agent","3") //会删除之前添加的所有的agent头部，并添加该条头部

    }


    internal  fun testHeader()=apply {
        addCustomHeaders()
    }






    /*******************************首部字段**********************************/

    /**
     * 通用首部字段
     */
    fun addGeneralHeader() {
        builders.add("Cache-Control","public,max-age=0,no-cache")
        builders.add("Connection","keep-Alive")  //默认连接为持久连接从1.1开始
        //不使用缓存
        builders.add("Pragma","no-cache")  //兼容服务器HTTP1.0
        builders.add("Cache-Control:no-cache") //服务器HTTP1.1
    }

    /**
     * 请求首部字段
     */
    fun addRequestHeader(){
        builders.add("Accept","text/html,text/plain,image/jpeg,q=0.3") //用户能够处理的媒体类型和优先级，默认为最大1
        builders.add("Accept-Encoding","gzip,compress,deflate,identity") //用户代理支持的内容编码
        builders.add("Accept-Language","zh-cn") //用户代理能够处理的语言
        builders.add("Host","ww.baidu.com")  //资源所在的主机名和端口号
        builders.add("If-Match","test-123")  //告知服务器匹配资源所用的实体标记(ETag)值，412 code
        builders.add("If-Modified-Since","") //资源是否过期，没有返回304
        builders.add("If-None-Match","*")   //与If-Match相反，与ETag值不一致时服务端处理请求
        builders.add("If-Range","test-123")  //范围请求判断是否与ETag值一致，反之返回全部资源
        builders.add("If-Unmodified-Since","")//与If-Modified-Since相反，资源在该日期之后更改过返回412
        builders.add("Range","bytes=5000-10000") //返回范围资源，206，无法处理返回番区资源 200
      }

    /**
     * 响应首部字段
     */
    fun addResponseHeader(){
        builders.add("Accept-Ranges","bytes") //告知客户端是否能处理范围请求，bytes，none
        builders.add("Age","600") //告知客户端，服务端在多久前创建了响应，单位s
        builders.add("ETag","123456") //服务端为每一份资源分配对应的ETag值
        builders.add("Location","http:ww.baidu.com") //配合30x开头的code，提供重定向的url
    }
}