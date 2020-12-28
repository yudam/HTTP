package com.mdy.http.authorization

import okhttp3.*

/**
 * User: maodayu
 * Date: 2020/12/1
 * Time: 11:25
 */
class ProxyAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val credential = Credentials.basic("test_name", "test-pwd")
        return response.request.newBuilder().addHeader("Proxy-Authorization", credential).build()
    }
}