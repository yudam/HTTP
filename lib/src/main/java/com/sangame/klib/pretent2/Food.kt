package com.sangame.klib.pretent2

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 19:07
 */
interface Food {

    fun nextFood(food: Food)

    fun writeFood(msg:String?):String
}