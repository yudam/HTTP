package com.sangame.klib

/**
 * User: maodayu
 * Date: 2020/12/9
 * Time: 11:03
 * 带接收者类型的函数、参数
 */

fun Int.run(arr: Int): Int {
    return this - arr
}

fun TData.run() {
    println("MDY:" + this.name)
    println("MDY:" + this.age)
}

var sum: Int.(Int) -> Int = { value -> this + value }
var sum2: Int.(other: Int) -> Int = { other -> this + other }

fun main(array: Array<String>) {
    val num = 10
    println("MDY:" + num.run(6))
    TData().run()
    val a = 3
    println("MDY: sum = " + a.sum2(4))
}
