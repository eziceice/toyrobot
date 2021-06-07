package com.rea.toyrobot.models

class Table(private val length: Int, private val width: Int, val obstacles: MutableList<Location> = mutableListOf()) {

    fun isValidLocation(location: Location): Boolean {
        return location.xAxis in 0 until length && location.yAxis in 0 until width && !obstacles.contains(location)
    }

    fun printMap(robotLocation: Location): List<List<String>> {
        val row = mutableListOf<MutableList<String>>()

        for (i in 0 until width) {
            val column = MutableList(length) { "*" }
            row.add(column)
        }

        obstacles.forEach {
            row[it.yAxis][it.xAxis] = "X"
        }
        row[robotLocation.yAxis][robotLocation.xAxis] = "R"

        row.asReversed().forEach {
            println(it.joinToString(" "))
        }

        return row
    }
}
