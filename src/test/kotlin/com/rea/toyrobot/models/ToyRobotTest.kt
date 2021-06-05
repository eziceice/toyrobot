package com.rea.toyrobot.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ToyRobotTest {

  @Test
  fun `should move if facing to north and facing location is in boundary`() {
    val location = Location(3, 3)
    val facing = Direction.NORTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.move()

    assertEquals(location.yAxis + 1, toyRobot.location.yAxis)
    assertEquals(location.xAxis, toyRobot.location.xAxis)
    assertEquals(facing, toyRobot.facing)
  }

  @Test
  fun `should move if facing to south and facing location is in boundary`() {
    val location = Location(3, 3)
    val facing = Direction.SOUTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.move()

    assertEquals(location.yAxis - 1, toyRobot.location.yAxis)
    assertEquals(location.xAxis, toyRobot.location.xAxis)
    assertEquals(facing, toyRobot.facing)
  }

  @Test
  fun `should move if facing to east and facing location is in boundary`() {
    val location = Location(3, 3)
    val facing = Direction.EAST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.move()

    assertEquals(location.yAxis, toyRobot.location.yAxis)
    assertEquals(location.xAxis + 1, toyRobot.location.xAxis)
    assertEquals(facing, toyRobot.facing)
  }

  @Test
  fun `should move if facing to west and facing location is in boundary`() {
    val location = Location(3, 3)
    val facing = Direction.WEST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.move()

    assertEquals(location.yAxis, toyRobot.location.yAxis)
    assertEquals(location.xAxis - 1, toyRobot.location.xAxis)
    assertEquals(facing, toyRobot.facing)
  }

  @Test
  fun `should not move if destination is not valid`() {
    val location = Location(0, 3)
    val facing = Direction.WEST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.move()

    assertEquals(location.yAxis, toyRobot.location.yAxis)
    assertEquals(location.xAxis, toyRobot.location.xAxis)
    assertEquals(facing, toyRobot.facing)
  }

  @Test
  fun `should rotate to south if facing to west and command is left`() {
    val location = Location(0, 3)
    val facing = Direction.WEST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.LEFT)

    assertEquals(Direction.SOUTH, toyRobot.facing)
  }

  @Test
  fun `should rotate to east if facing to south and command is left`() {
    val location = Location(0, 3)
    val facing = Direction.SOUTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.LEFT)

    assertEquals(Direction.EAST, toyRobot.facing)
  }

  @Test
  fun `should rotate to north if facing to east and command is left`() {
    val location = Location(0, 3)
    val facing = Direction.EAST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.LEFT)

    assertEquals(Direction.NORTH, toyRobot.facing)
  }

  @Test
  fun `should rotate to west if facing to north and command is left`() {
    val location = Location(0, 3)
    val facing = Direction.NORTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.LEFT)

    assertEquals(Direction.WEST, toyRobot.facing)
  }

  @Test
  fun `should rotate to north if facing to west and command is right`() {
    val location = Location(0, 3)
    val facing = Direction.WEST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.RIGHT)

    assertEquals(Direction.NORTH, toyRobot.facing)
  }

  @Test
  fun `should rotate to east if facing to north and command is right`() {
    val location = Location(0, 3)
    val facing = Direction.NORTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.RIGHT)

    assertEquals(Direction.EAST, toyRobot.facing)
  }

  @Test
  fun `should rotate to south if facing to east and command is right`() {
    val location = Location(0, 3)
    val facing = Direction.EAST
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.RIGHT)

    assertEquals(Direction.SOUTH, toyRobot.facing)
  }

  @Test
  fun `should rotate to west if facing to south and command is right`() {
    val location = Location(0, 3)
    val facing = Direction.SOUTH
    val table = Table(5, 5)
    val toyRobot = ToyRobot(location, facing, table)
    toyRobot.rotate(RotateCommand.RIGHT)

    assertEquals(Direction.WEST, toyRobot.facing)
  }
}