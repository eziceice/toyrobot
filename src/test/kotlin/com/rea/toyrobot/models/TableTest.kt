package com.rea.toyrobot.models

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TableTest {

    private lateinit var table: Table

    @BeforeEach
    fun setup() {
        table = Table(5, 5)
    }

    @Test
    fun `should return true if x and y are in boundary`() {
        val location = Location(3, 3)
        assertTrue(table.isValidLocation(location))
    }

    @Test
    fun `should return true if x and y are higher boundary`() {
        val location = Location(4, 4)
        assertTrue(table.isValidLocation(location))
    }

    @Test
    fun `should return true if x and y are lower boundary`() {
        val location = Location(0, 0)
        assertTrue(table.isValidLocation(location))
    }

    @Test
    fun `should return false if x and y are both over the higher boundary`() {
        val location = Location(90, 90)
        assertFalse(table.isValidLocation(location))
    }

    @Test
    fun `should return false if x and y are both under the lower boundary`() {
        val location = Location(-1, -10)
        assertFalse(table.isValidLocation(location))
    }

    @Test
    fun `should return false if x is over the higher boundary`() {
        val location = Location(90, 3)
        assertFalse(table.isValidLocation(location))
    }

    @Test
    fun `should return false if x is under the lower boundary`() {
        val location = Location(-1, 3)
        assertFalse(table.isValidLocation(location))
    }

    @Test
    fun `should return false if y is over the higher boundary`() {
        val location = Location(3, 90)
        assertFalse(table.isValidLocation(location))
    }

    @Test
    fun `should return false if y is under the lower boundary`() {
        val location = Location(3, -1)
        assertFalse(table.isValidLocation(location))
    }
}
