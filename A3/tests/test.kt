import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculadoraTest {
    private lateinit var calculadora: Calculadora

    @BeforeEach
    fun setUp() {
        calculadora = Calculadora()
    }

    @Test
    fun Somar() {
        assertEquals(5.0, calculadora.somar(2.0, 3.0), 0.001)
    }

    @Test
    fun Subtrair() {
        assertEquals(1.0, calculadora.subtrair(5.0, 4.0), 0.001)
    }

    @Test
    fun Multiplicar() {
        assertEquals(6.0, calculadora.multiplicar(2.0, 3.0), 0.001)
    }

    @Test
    fun Dividir() {
        assertEquals(2.0, calculadora.dividir(6.0, 3.0), 0.001)
    }

    @Test
    fun DividirPorZero() {
        assertThrows<IllegalArgumentException> {
            calculadora.dividir(1.0, 0.0)
        }
    }

    @Test
    fun SomarNumerosNegativos() {
        assertEquals(-5.0, calculadora.somar(-2.0, -3.0), 0.001)
    }

    @Test
    fun SubtrairParaResultadoNegativo() {
        assertEquals(-1.0, calculadora.subtrair(3.0, 4.0), 0.001)
    }

    @Test
    fun MultiplicarPorZero() {
        assertEquals(0.0, calculadora.multiplicar(0.0, 100.0), 0.001)
    }

    @Test
    fun DividirResultadoNaoInteiro() {
        assertEquals(2.5, calculadora.dividir(5.0, 2.0), 0.001)
    }

    @Test
    fun OperacoesComZero() {
        assertEquals(0.0, calculadora.somar(0.0, 0.0), 0.001)
        assertEquals(0.0, calculadora.subtrair(0.0, 0.0), 0.001)
        assertEquals(0.0, calculadora.multiplicar(0.0, 0.0), 0.001)
        assertEquals(0.0, calculadora.somar(5.0, -5.0), 0.001)
    }
}