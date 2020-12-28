package com.sangame.klib.pretent2

/**
 * User: maodayu
 * Date: 2020/12/10
 * Time: 19:08
 */
class Lisi : Food {

    private lateinit var food: Food

    override fun nextFood(food: Food) {
        this.food = food
    }


    override fun writeFood(msg:String): String {

        return   food.writeFood(msg+"banana")
    }
}