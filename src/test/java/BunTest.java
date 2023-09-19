import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final String NAME = "green bun";
    private final float PRICE = 1500;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(NAME, PRICE);
        String actualName = bun.getName();
        Assert.assertEquals("Неверное имя булочки", NAME, actualName);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(NAME, PRICE);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(PRICE, actualPrice, 0);
    }
}
