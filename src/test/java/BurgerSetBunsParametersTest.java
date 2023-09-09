import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(Parameterized.class)
public class BurgerSetBunsParametersTest {
  //  private float price;
  //  private String name;
    private Bun bunOne;
    private float expectedPrice;
    private String expectedName;
    public BurgerSetBunsParametersTest(Bun bun, String expectedName, float expectedPrice){
//        this.name = name;
//        this.price = price;
        this.bunOne = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] setBun(){
        return new Object[][]{
                {new Bun("NameOne", 123), "NameOne", 123}
        };
    }
    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bunOne);
        String actualName = burger.bun.getName();
        float actualPrice = burger.bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice,0);
        Assert.assertEquals(expectedName, actualName);
    }

}
