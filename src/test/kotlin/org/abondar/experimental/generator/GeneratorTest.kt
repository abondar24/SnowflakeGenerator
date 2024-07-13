package org.abondar.experimental.generator

import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class GeneratorTest {

    @Test
    fun `Generate ID `() {
        val generator = SnowflakeGenerator(1)

        val id = generator.generateId()
        println(id)

        assertNotNull(id)
    }


    @Test
    fun `Generate unique ID`() {
        val generator = SnowflakeGenerator(1)

        val id = generator.generateId()
        val id1 = generator.generateId()

        assertNotEquals(id, id1)
    }

    @Test
    fun `Generate IDs in chronological order`() {
        val generator = SnowflakeGenerator(1)
        val ids = mutableListOf<Long>()

        repeat(10) {
            ids.add(generator.generateId())
            Thread.sleep(1)
        }

        assertEquals(ids.sorted(), ids)
    }

    @Test
    fun `Fail on invalid machine ID`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            SnowflakeGenerator(1024)
        }

        assertTrue(exception.message!!.contains("Machine ID must be between 0..MAX_MACHINE_ID"))
    }
}