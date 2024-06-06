import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CalculatorServiceTest {

    private val calculator = mockk<Calculator>()
    private val calculatorService = CalculatorService(calculator)

    @Test
    fun `addition of 2 and 3 using service returns 5`() {
        every { calculator.add(2.0, 3.0) } returns 5.0

        val result = calculatorService.performAddition(2.0, 3.0)

        assertEquals(5.0, result)
        verify { calculator.add(2.0, 3.0) }
    }

    @Test
    fun `subtraction of 2 from 3 using service returns -1`() {
        every { calculator.subtract(2.0, 3.0) } returns -1.0

        val result = calculatorService.performSubtraction(2.0, 3.0)

        assertEquals(-1.0, result)
        verify { calculator.subtract(2.0, 3.0) }
    }

    @Test
    fun `multiplication of 2 and 3 using service returns 6`() {
        every { calculator.multiply(2.0, 3.0) } returns 6.0

        val result = calculatorService.performMultiplication(2.0, 3.0)

        assertEquals(6.0, result)
        verify { calculator.multiply(2.0, 3.0) }
    }

    @Test
    fun `division of 6 by 3 using service returns 2`() {
        every { calculator.divide(6.0, 3.0) } returns 2.0

        val result = calculatorService.performDivision(6.0, 3.0)

        assertEquals(2.0, result)
        verify { calculator.divide(6.0, 3.0) }
    }

    @Test
    fun `power of 2 to the 3 using service returns 8`() {
        every { calculator.power(2.0, 3.0) } returns 8.0

        val result = calculatorService.performPower(2.0, 3.0)

        assertEquals(8.0, result)
        verify { calculator.power(2.0, 3.0) }
    }

    @Test
    fun `square root of 4 using service returns 2`() {
        every { calculator.sqrt(4.0) } returns 2.0

        val result = calculatorService.performSqrt(4.0)

        assertEquals(2.0, result)
        verify { calculator.sqrt(4.0) }
    }

    @Test
    fun `modulus of 10 by 3 using service returns 1`() {
        every { calculator.modulus(10.0, 3.0) } returns 1.0

        val result = calculatorService.performModulus(10.0, 3.0)

        assertEquals(1.0, result)
        verify { calculator.modulus(10.0, 3.0) }
    }
}

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `addition of 2 and 3 returns 5`() {
        val result = calculator.add(2.0, 3.0)
        assertEquals(5.0, result)
    }

    @Test
    fun `subtraction of 2 from 3 returns -1`() {
        val result = calculator.subtract(2.0, 3.0)
        assertEquals(-1.0, result)
    }

    @Test
    fun `multiplication of 2 and 3 returns 6`() {
        val result = calculator.multiply(2.0, 3.0)
        assertEquals(6.0, result)
    }

    @Test
    fun `division of 6 by 3 returns 2`() {
        val result = calculator.divide(6.0, 3.0)
        assertEquals(2.0, result)
    }

    @Test
    fun `power of 2 to the 3 returns 8`() {
        val result = calculator.power(2.0, 3.0)
        assertEquals(8.0, result)
    }

    @Test
    fun `square root of 4 returns 2`() {
        val result = calculator.sqrt(4.0)
        assertEquals(2.0, result)
    }

    @Test
    fun `modulus of 10 by 3 returns 1`() {
        val result = calculator.modulus(10.0, 3.0)
        assertEquals(1.0, result)
    }

    @Test
    fun `division of 10 by zero throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            calculator.divide(10.0, 0.0)
        }
    }

    @Test
    fun `square root of negative 1 throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            calculator.sqrt(-1.0)
        }
    }
}