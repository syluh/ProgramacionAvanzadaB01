import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semana8.SimpleCalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalcTest {
    @DisplayName("Test de suma")
    @Test
    public void testSuma(){
        SimpleCalc simpleCalc = new SimpleCalc(20,10);
        assertEquals(30, simpleCalc.suma());
    }

    @DisplayName("Test de resta")
    @Test
    public void testResta(){
        SimpleCalc simpleCalc = new SimpleCalc(20,10);
        assertEquals(10, simpleCalc.restar());
    }
}
