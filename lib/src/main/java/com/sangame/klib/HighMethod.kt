package com.sangame.klib

/**
 * User: maodayu
 * Date: 2020/12/9
 * Time: 14:46
 */

/**
 *  将函数作为参数
 */
fun CharSequence.samba(sector: (Char) -> Int): Int {
    var sum: Int = 0
    for (element in this) {
        sum += sector(element)
    }
    return sum
}


fun main(array: Array<String>){

    var testStr = "111"
    val sum = testStr.samba{
        it.toInt()
    }
    println("MDY: sum=$sum")

    testStr = testStr.run {
        this.plus("222")
    }

    println("MDY: testStr=$testStr")

    run {  }
}