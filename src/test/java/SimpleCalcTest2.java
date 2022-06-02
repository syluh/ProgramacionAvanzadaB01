import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semana8.SimpleCalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalcTest2 {
    static SimpleCalc simpleCalc;

    @BeforeAll
    public static void crearClase(){
        simpleCalc = new SimpleCalc(20, 10);
    }

    @DisplayName("Test de suma")
    @Test
    public void testSuma(){
        assertEquals(30, simpleCalc.suma());
    }

    @DisplayName("Test de resta")
    @Test
    public void testResta(){
        assertEquals(10, simpleCalc.restar());
    }
}
