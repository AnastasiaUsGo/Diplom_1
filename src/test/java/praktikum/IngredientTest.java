package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}, Имя ингредиента: {1}, Цена: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                { SAUCE, "hot sauce", 100 },
                { SAUCE, "sour cream", 200 },
                { SAUCE, "chili sauce", 300 },
                { FILLING, "cutlet", 100 },
                { FILLING, "dinosaur", 200 },
                { FILLING, "sausage", 300 },
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0.001f);


    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }
}