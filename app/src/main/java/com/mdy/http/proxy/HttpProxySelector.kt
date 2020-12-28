package com.mdy.http.proxy

import java.io.IOException
import java.net.*

/**
 * 自定义的代理选择器，内置指定的几种代理
 */
class HttpProxySelector(val ip :String,val port:Int) : ProxySelector() {
    override fun select(uri: URI?): MutableList<Proxy> {
        val proxyList  = mutableListOf<Proxy>()
        proxyList.add(Proxy.NO_PROXY)   //直连
        proxyList.add(Proxy(Proxy.Type.DIRECT,InetSocketAddress(ip,port)))  //直连
        proxyList.add(Proxy(Proxy.Type.HTTP,InetSocketAddress(ip,port)))    // HTTP、FTP等高级代理
        proxyList.add(Proxy(Proxy.Type.SOCKS,InetSocketAddress(ip,port)))   // SOCKS v4或v5代理
        return proxyList
    }

    override fun connectFailed(uri: URI?, sa: SocketAddress?, ioe: IOException?) {
       println("无法连接到代理")
    }
}