package com.rea.toyrobot.services

import com.rea.toyrobot.models.Direction
import com.rea.toyrobot.models.Location
import com.rea.toyrobot.models.RotateCommand
import com.rea.toyrobot.models.Table
import com.rea.toyrobot.models.ToyRobot
import java.util.Scanner

class ToyRobotService(private val table: Table) {

  private val placeRegex = Regex("(PLACE) ([0-9]+),([0-9]+),(NORTH|EAST|SOUTH|WEST)")
  private val activityRegex = Regex("(MOVE|REPORT|LEFT|RIGHT)")
  private var toyRobot: ToyRobot? = null

  fun start(scanner: Scanner) {
    while (scanner.hasNext()) {
      processCommand(scanner.nextLine())
    }
  }

  private fun processCommand(command: String) {
    when {
      command.matches(placeRegex) -> {
        init(command)
      }

      command.matches(activityRegex) && toyRobot != null -> {
        performAction(command)
      }

      else -> println(
        "Sorry, the command you just entered is not valid or the robot hasn't been initialized yet."
      )
    }
  }

  private fun performAction(activityCommand: String) =
    when (activityRegex.matchEntire(activityCommand)!!.value) {
      "MOVE" -> {
        toyRobot!!.move()
      }

      "REPORT" -> {
        toyRobot!!.report()
      }

      else -> {
        toyRobot!!.rotate(RotateCommand.valueOf(activityCommand))
      }
    }

  private fun init(placeCommand: String) {
    val destructedPlaceCommand = placeRegex.matchEntire(placeCommand)!!.destructured
    val startLocation = Location(
      destructedPlaceCommand.component2().toInt(), destructedPlaceCommand.component3().toInt()
    )
    if (table.isValidLocation(startLocation)) {
      val direction = Direction.valueOf(destructedPlaceCommand.component4())
      toyRobot = ToyRobot(startLocation, direction, table)
    }
  }
}