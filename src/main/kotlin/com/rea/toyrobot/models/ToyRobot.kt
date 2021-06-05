package com.rea.toyrobot.models

class ToyRobot(
  var location: Location,
  var facing: Direction,
  private val table: Table
) {

  fun move() {
    location = getDestination()
  }

  fun rotate(rotateCommand: RotateCommand) {
    when (rotateCommand) {
      RotateCommand.LEFT -> rotateLeft()
      RotateCommand.RIGHT -> rotateRight()
    }
  }

  fun report() = println("$location,$facing")

  private fun rotateLeft() {
    facing = when (facing) {
      Direction.WEST -> Direction.SOUTH
      Direction.SOUTH -> Direction.EAST
      Direction.EAST -> Direction.NORTH
      Direction.NORTH -> Direction.WEST
    }
  }

  private fun rotateRight() {
    facing = when (facing) {
      Direction.WEST -> Direction.NORTH
      Direction.NORTH -> Direction.EAST
      Direction.EAST -> Direction.SOUTH
      Direction.SOUTH -> Direction.WEST
    }
  }

  private fun getDestination(): Location {
    val destination: Location = when (facing) {
      Direction.NORTH -> Location(location.xAxis, location.yAxis + 1)
      Direction.SOUTH -> Location(location.xAxis, location.yAxis - 1)
      Direction.EAST -> Location(location.xAxis + 1, location.yAxis)
      Direction.WEST -> Location(location.xAxis - 1, location.yAxis)
    }
    return if (table.isValidLocation(destination)) {
      destination
    } else {
      location
    }
  }
}