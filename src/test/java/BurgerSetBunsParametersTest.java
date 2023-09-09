import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(Parameterized.class)
public class BurgerSetBunsParametersTest {
    private Bun bunOne;
    boolean isSetBun;

    public BurgerSetBunsParametersTest(Bun bun, boolean isSetBun) {
        this.bunOne = bun;
        this.isSetBun = isSetBun;
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {new Bun("NameOne", 123), true}
        };
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunOne);
        String actualName = burger.bun.getName();
        float actualPrice = burger.bun.getPrice();
        boolean isActualSetBun = ((bunOne.getName().equals(actualName)) & (bunOne.getPrice() == actualPrice));
        Assert.assertEquals(isSetBun, isActualSetBun);
    }

}
