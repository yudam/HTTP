package com.mdy.http.proxy

import java.net.ProxySelector

/**
 * User: maodayu
 * Date: 2020/9/30
 * Time: 13:28
 */

/**
 * @param ip 代理IP
 * @param port 代理端口
 * 设置代理选择器，默认走的是Java中的 DefaultProxySelector
 */
fun setAssignProxySelector(ip: String, port: Int) {
    ProxySelector.setDefault(HttpProxySelector(ip, port))
}