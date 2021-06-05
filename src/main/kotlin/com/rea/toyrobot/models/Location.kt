package com.rea.toyrobot.models

data class Location(val xAxis: Int, val yAxis: Int) {
  override fun toString() = "$xAxis,$yAxis"
}