package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void enumValueLength() {
        int expected = 2;
        int actual = IngredientType.values().length;
        assertEquals("Фактическое количество типов ингредиентов не совпало с ожидаемым", expected, actual);
    }

    @Test
    public void enumContainsSauce() {
        String expected = "SAUCE";
        String actual = IngredientType.valueOf("SAUCE").toString();
        assertEquals(expected, actual);
        assertEquals("FILLING", IngredientType.valueOf("FILLING").toString());
    }

    @Test
    public void enumContainsFilling() {
        String expected = "FILLING";
        String actual = IngredientType.valueOf("FILLING").toString();
        assertEquals(expected, actual);
    }
}