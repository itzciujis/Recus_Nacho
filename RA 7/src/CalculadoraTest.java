import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    void testSuma() {
        Calculadora calc = new Calculadora();
        assertEquals(8, calc.sumar(5, 3));
    }
}