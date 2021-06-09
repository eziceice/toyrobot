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

    @Test
    fun `should place an obstacle at (1,0)`() {
        val location = Location(0, 0)
        val facing = Direction.EAST
        val table = Table(5, 5)
        val toyRobot = ToyRobot(location, facing, table)
        val obstacle = toyRobot.placeObject()

        assertEquals(obstacle, table.obstacles[0])
        assertEquals(1, table.obstacles.size)
        assertEquals(Location(1,0), obstacle)
    }

    @Test
    fun `should return null if obstacle is ous of the boundary`() {
        val location = Location(4, 4)
        val facing = Direction.NORTH
        val table = Table(5, 5)
        val toyRobot = ToyRobot(location, facing, table)
        val obstacle = toyRobot.placeObject()

        assertEquals(0, table.obstacles.size)
        assertEquals(null, obstacle)
    }

    @Test
    fun `should return robot at (3,0) and obstacle at (4,0)`() {
        val location = Location(3, 0)
        val facing = Direction.NORTH
        val table = Table(5, 5)
        val toyRobot = ToyRobot(location, facing, table)
        val obstacle = Location(4,0)
        table.obstacles.add(obstacle)

        val tableMap = toyRobot.map()

        assertEquals(5, tableMap.size)
        tableMap.forEach {
            assertEquals(5, it.size)
        }
        assertEquals("R", tableMap[0][3])
        assertEquals("X", tableMap[0][4])
    }

}
