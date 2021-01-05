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

    scope.async {
        delay(4000)
        Log.i("MDY", "scope-async:${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    Log.i("MDY", "end:${Thread.currentThread().name}")
}

/**
 * GlobalScope
 */
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

/**
 * runBlocking--1
 */
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


/**
 * runBlocking--2
 */
fun testRunBlocking2() {
    Log.i("MDY", "start:${Thread.currentThread().name}")
    GlobalScope.launch {
        Log.i("MDY", "GlobalScope1:${Thread.currentThread().name}")
        delay(200)
        Log.i("MDY", "GlobalScope2:${Thread.currentThread().name}")
    }
    runBlocking(Dispatchers.IO) {
        launch {
            delay(1000)
            Log.i("MDY", "coroutineA:${Thread.currentThread().name}")
        }
        Log.i("MDY", "coroutineC--runBlocking:${Thread.currentThread().name}")
    }
    Log.i("MDY", "end:${Thread.currentThread().name}")
}

fun testSupervisorScope() {
    Log.i("MDY", "start:${Thread.currentThread().name}")
    runBlocking {
        Log.i("MDY", "runBlocking:${Thread.currentThread().name}")
        supervisorScope {
            launch {
                delay(200)
                Log.i("MDY", "supervisorScope1:${Thread.currentThread().name}")
                throw Exception("test")
            }

            launch {
                delay(300)
                Log.i("MDY", "supervisorScope2:${Thread.currentThread().name}")
            }
        }
    }
    Log.i("MDY", "end:${Thread.currentThread().name}")
}

val mainScope = MainScope()
fun testMainScope() {
    mainScope.launch { }
}

fun destory() {
    mainScope.cancel()
}



