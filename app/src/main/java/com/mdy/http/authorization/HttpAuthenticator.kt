package com.mdy.http.authorization

import okhttp3.Credentials
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.net.Authenticator

/**
 * User: maodayu
 * Date: 2020/12/1
 * Time: 11:07
 */
class HttpAuthenticator : okhttp3.Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val credential = Credentials.basic("test_name","test-pwd")
       return response.request.newBuilder().addHeader("Authorization",credential).build()
    }
}