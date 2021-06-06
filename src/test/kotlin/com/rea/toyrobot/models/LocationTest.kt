package com.rea.toyrobot.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LocationTest {
    @Test
    fun `should return the location string separated by comma`() {
        val location = Location(5, 5)
        assertEquals("5,5", location.toString())
    }
}
