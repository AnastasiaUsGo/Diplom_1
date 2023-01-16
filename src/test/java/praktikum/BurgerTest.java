package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun expected = bun;
        Bun actual = burger.bun;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int expected = 2;
        int actual = burger.ingredients.size();
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        boolean expected = true;
        boolean actual = burger.ingredients.size() == 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(1, 0);
        assertEquals("sausage", burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        float expected = 400f;
        float actual = burger.getPrice();
        Assert.assertEquals(expected,actual,0.001f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        String expected = String.format("(==== black bun ====)%n" + "= filling cutlet =%n" + "(==== black bun ====)%n"
                + "%nPrice: 700.000000%n");
        String actual = burger.getReceipt();
        Assert.assertEquals(expected,actual);
    }
}