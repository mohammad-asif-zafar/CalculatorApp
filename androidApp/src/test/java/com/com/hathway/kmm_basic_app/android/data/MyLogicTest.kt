package com.com.hathway.kmm_basic_app.android.data

import com.hathway.kmm_basic_app.android.data.MyLogic
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class MyLogicTest {

    lateinit var logic: MyLogic

    @BeforeTest
    fun setUp() {
        logic = MyLogic()
    }

    @Test
    fun testAdditionOfTwoPositiveNumbers() {
        val result = logic.addNumbers(2, 3)
        assertEquals(5, result)
    }

    @Test
    fun testAdditionWithNegativeNumber() {
        val result = logic.addNumbers(-4, 2)
        assertEquals(-2, result)
    }

    @Test
    fun testAdditionWithZero() {
        val result = logic.addNumbers(0, 5)
        assertEquals(5, result)
    }

    @Test
    fun `test Both zero numbers`() {
        val result = logic.addNumbers(0, 0)
        assertEquals(0, result)
    }

    @Test
    fun `testAdditionWithNegativeNumber with Negative`() {
        val result = logic.addNumbers(-4, -2)
        assertEquals(-6, result)
    }

    @Test
    fun `test subNumbers for both postive numbers`() {
        assertEquals(2, logic.difference(4, 6))
    }

    @Test
    fun testSquareAndAddFive() {
        val clazz = MyLogic::class.java
        val method = clazz.getDeclaredMethod("sub", Int::class.java, Int::class.java)
        method.isAccessible = true

        assertEquals(3, method.invoke(logic, 5, 2))
        assertEquals(3, method.invoke(logic, 2, 5))
        assertEquals(0, method.invoke(logic, 4, 4))
    }
}
