import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;
    private final String actualName;
    private final float actualPrice;
    private final String NAME = "Burger";
    private final float PRICE = 12;
    public BunTest(String name, String expectedName){
        this.actualName = name;
        this.expectedName = expectedName;
        this.expectedPrice = PRICE;
        this.actualPrice = PRICE;
    }

    public BunTest(float price, float expectedPrice){
        this.expectedPrice = expectedPrice;
        this.actualPrice = price;
        this.expectedName = NAME;
        this.actualName = NAME;
    }
    @Parameterized.Parameters
    public static Object[][] bunTest(){
        return new Object[][]{
                {"Lopast", "Lopast"},
                {12,12},
        };
    }

@Test
public void getNameTest(){
    Bun bun = new Bun(actualName, PRICE);
    String actualName = bun.getName();
    Assert.assertEquals("Неверное имя булочки", expectedName, actualName);
}

@Test
    public void getPriceTest(){
    Bun bun = new Bun(NAME, actualPrice);
    float actualPrice = bun.getPrice();
    Assert.assertEquals(expectedPrice, actualPrice, 0);
}
}
