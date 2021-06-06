package com.rea.toyrobot.models

class Table(private val length: Int, private val width: Int) {
    fun isValidLocation(location: Location): Boolean {
        return location.xAxis in 0..length && location.yAxis in 0..width
    }
}
