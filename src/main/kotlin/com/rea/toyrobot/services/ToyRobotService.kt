package com.rea.toyrobot.services

import com.rea.toyrobot.models.ActionCommand
import com.rea.toyrobot.models.Direction
import com.rea.toyrobot.models.Location
import com.rea.toyrobot.models.RotateCommand
import com.rea.toyrobot.models.Table
import com.rea.toyrobot.models.ToyRobot
import java.util.Scanner

class ToyRobotService(private val table: Table) {

    private val placeRegex = Regex("(PLACE) ([0-9]+),([0-9]+),(NORTH|EAST|SOUTH|WEST)")
    private val actionRegex = Regex("(MOVE|REPORT)")
    private val rotateRegex = Regex("(LEFT|RIGHT)")
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

            command.matches(actionRegex) && toyRobot != null -> {
                performAction(command)
            }

            command.matches(rotateRegex) && toyRobot != null -> {
                performRotate(command)
            }

            else -> println(
                "Sorry, the command you just entered is not valid or the robot hasn't been initialized yet."
            )
        }
    }

    private fun performAction(actionCommand: String) {
        when (ActionCommand.valueOf(actionRegex.matchEntire(actionCommand)!!.value)) {
            ActionCommand.MOVE -> {
                toyRobot?.move()
            }

            ActionCommand.REPORT -> {
                toyRobot?.report()
            }
        }
    }

    private fun performRotate(rotateCommand: String) = toyRobot?.rotate(
        RotateCommand.valueOf(rotateCommand)
    )

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
