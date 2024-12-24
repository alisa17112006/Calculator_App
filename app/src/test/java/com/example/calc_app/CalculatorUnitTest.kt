package com.example.calc_app
import com.example.calc_app.calculateResult

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculatorUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testDivisionByZero() {
        val expression = "10 / 0"
        val expected = "Ошибка"

        val result = calculateResult(expression)

        assertEquals(expected, result, "Деление на 0 должно возвращать 'Ошибка'")
    }

    @Test
    fun testEmptyInput() {
        assertEquals("Ошибка", calculateResult(""))
    }

    @Test
    fun testTrigonometricFunctions() {
        assertEquals("0.0", calculateResult("sin 0"))
        assertEquals("1.0", calculateResult("cos 0"))
        assertEquals("0.0", calculateResult("tan 0"))
        assertEquals("Infinity", calculateResult("cot 0")) // Проверяем асимптоту cot(0)
    }

}