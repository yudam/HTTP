package com.mdy.http

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

/**
 * User: maodayu
 * Date: 2020/12/29 18:56
 */

/**
 * 协程：本质是切换线程，完成后自动切换到开始线程
 */

suspend fun testSuspendIO(){
    withContext(Dispatchers.IO){}
}
suspend fun testSuspendMAIN(){
    withContext(Dispatchers.Main){}
}

suspend fun testSuspendDefault(){
    withContext(Dispatchers.IO){}
}

suspend fun testSuspendUnconfined(){
    withContext(Dispatchers.Unconfined){}
}
