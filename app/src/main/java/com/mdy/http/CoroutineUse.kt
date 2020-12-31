package com.mdy.http

import android.util.Log
import kotlinx.coroutines.*

/**
 * User: maodayu
 * Date: 2020/12/29 18:56
 */

fun testScope() {
    val scope = CoroutineScope(Dispatchers.Main)
    Log.i("MDY", "start:${Thread.currentThread().name}")
    scope.launch {
        delay(4000)
        Log.i("MDY", "scope:${Thread.currentThread().name}")

    }
    Thread.sleep(2000)
    Log.i("MDY", "end:${Thread.currentThread().name}")

    runBlocking {

    }
}

fun testGlobalScope() {
    Log.i("MDY", "start:${Thread.currentThread().name}")
    GlobalScope.launch(Dispatchers.Main) {

        launch {
            delay(1000)
            Log.i("MDY", "coroutineA:${Thread.currentThread().name}")
        }

        launch {
            delay(2000)
            Log.i("MDY", "coroutineB:${Thread.currentThread().name}")
        }

        Log.i("MDY", "coroutineC:${Thread.currentThread().name}")
    }
    Log.i("MDY", "end:${Thread.currentThread().name}")
    Thread.sleep(500)
}

fun testRunBlocking() {
    Log.i("MDY", "start:${Thread.currentThread().name}")

    runBlocking {

        launch {
            repeat(3) {
                delay(1000)
                Log.i("MDY", "coroutineA:${Thread.currentThread().name}:" + it)
            }
        }

        launch {
            repeat(3) {
                delay(2000)
                Log.i("MDY", "coroutineB:${Thread.currentThread().name}:" + it)
            }

        }

        Log.i("MDY", "coroutineC--runBlocking:${Thread.currentThread().name}")
    }

    Log.i("MDY", "end:${Thread.currentThread().name}")

}

fun testRunBlocking2(){
    Log.i("MDY", "start:${Thread.currentThread().name}")
    GlobalScope.launch {
        delay(200)
        Log.i("MDY", "GlobalScope:${Thread.currentThread().name}")
    }
    runBlocking {
        launch {
            delay(1000)
            Log.i("MDY", "coroutineA:${Thread.currentThread().name}")
        }
        Log.i("MDY", "coroutineC--runBlocking:${Thread.currentThread().name}")
    }
    Log.i("MDY", "end:${Thread.currentThread().name}")
}

