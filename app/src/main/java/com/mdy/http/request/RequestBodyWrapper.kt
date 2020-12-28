package com.mdy.http.request

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * 请求报文中主体的类型，通常在图片，文件上传时使用。
 * Okhttp中自带的主体类型： FormBody、MultipartBody。
 * 常见的四种Post请求，包含Content-Type和消息主体编码（Content-Encoding）
 * GET和HEAD不需要添加Body，当然添加了也没错
 */
class RequestBodyWrapper internal constructor() {

    companion object {
        /**
         *表单的形式进行提交， Okhttp中帮我们封装了FormBody
         */
        fun createDefaultBody(): RequestBody {
            val bodyMsg = "application/x-www-form-urlencoded"
            val mediaType = bodyMsg.toMediaType()
            return bodyMsg.toRequestBody(mediaType)
        }

        /**
         * 上传文件，一般配合boundary来分割实体
         */
        fun createFormDataBody(): RequestBody {
            val bodyMsg = "multipart/form-data"
            val mediaType = bodyMsg.toMediaType()
            return bodyMsg.toRequestBody(mediaType)
        }

        /**
         * 提交复杂的结构化数据，特别适合 RESTful 的接口
         */
        fun createJsonBody(): RequestBody {
            val bodyMsg = "application/json"
            val mediaType = bodyMsg.toMediaType()
            return bodyMsg.toRequestBody(mediaType)
        }

        /**
         * xml的格式提交数据
         */
        fun createXmlBody(): RequestBody {
            val bodyMsg = "text/xml"
            val mediaType = bodyMsg.toMediaType()
            return bodyMsg.toRequestBody(mediaType)
        }

    }
}