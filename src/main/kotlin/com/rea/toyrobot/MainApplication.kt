package com.rea.toyrobot

import com.rea.toyrobot.models.Table
import com.rea.toyrobot.services.ToyRobotService
import java.util.Scanner

fun main() {
    ToyRobotService(Table(5, 5)).start(Scanner(System.`in`))
}
