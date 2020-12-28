package com.sangame.klib

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 11:46
 */


fun main(array: Array<String>) {

    val data = TData()

    run {
        data.name = "nishishui"
    }

    println("run1  ${data.name}")
    println("--------------------")
    data.run {
        name = "mdy"
    }

    println("run2  ${data.name}")
    println("--------------------")

    with(data) {
        println("with ${name}")
    }
    println("--------------------")
    data.apply {
        name = "apply_data"
    }

    println("apply ${data.name}")

    println("--------------------")

    data.also {
        println("also ${it.name}")
    }

    data.takeIf {
        it.name == "mdy"
    }

    data.takeUnless {
        it.name != "mdy"
    }

    repeat(3){
        println("repeat $it")
    }
}