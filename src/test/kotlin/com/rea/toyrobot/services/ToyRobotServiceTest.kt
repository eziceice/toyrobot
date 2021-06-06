package com.rea.toyrobot.services

import com.rea.toyrobot.models.Table
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.Scanner

internal class ToyRobotServiceTest {

  private val outContent = ByteArrayOutputStream()
  private val originalOut = System.out
  private lateinit var toyRobotService: ToyRobotService

  @BeforeEach
  fun setup() {
    toyRobotService = ToyRobotService(Table(5, 5))
    System.setOut(PrintStream(outContent))
  }

  @AfterEach
  fun tearDown() {
    System.setOut(originalOut)
  }

  @Test
  fun `should return (0,1,NORTH) result`() {
    val input = "PLACE 0,0,NORTH\n" +
      "MOVE\n" +
      "REPORT"
    toyRobotService.start(Scanner(input))

    assertEquals("0,1,NORTH", outContent.toString().trim())
  }

  @Test
  fun `should return (0,0,WEST) result`() {
    val input = "PLACE 0,0,NORTH\n" +
      "LEFT\n" +
      "REPORT"
    toyRobotService.start(Scanner(input))

    assertEquals("0,0,WEST", outContent.toString().trim())
  }

  @Test
  fun `should return (3,3,NORTH) result`() {
    val input = "PLACE 1,2,EAST\n" +
      "MOVE\n" +
      "MOVE\n" +
      "LEFT\n" +
      "MOVE\n" +
      "REPORT"
    toyRobotService.start(Scanner(input))

    assertEquals("3,3,NORTH", outContent.toString().trim())
  }

  @Test
  fun `should return error result - if unexpected command is entered`() {
    val input = "xyz12345"
    toyRobotService.start(Scanner(input))

    assertEquals(
      "Sorry, the command you just entered is not valid or the robot hasn't been initialized yet.",
      outContent.toString().trim()
    )
  }

  @Test
  fun `should return error result - if report command is entered first`() {
    val input = "report"
    toyRobotService.start(Scanner(input))

    assertEquals(
      "Sorry, the command you just entered is not valid or the robot hasn't been initialized yet.",
      outContent.toString().trim()
    )
  }
}