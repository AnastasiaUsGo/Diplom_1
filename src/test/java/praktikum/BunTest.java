package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    Bun bun = new Bun ("red bun", 300);

    @Test
    public void getBunNameTest() {
        String expected = "red bun";
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBunPriceTest() {
        float expected = 300;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0.001f);
    }
}