import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(Parameterized.class)
public class BurgerSetBunsParametersTest {
    private Bun bunOne;
    private final boolean IS_SET_BUN = true;

    public BurgerSetBunsParametersTest(Bun bun) {
        this.bunOne = bun;
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {new Bun("NameOne", 123)}
        };
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunOne);
        String actualName = burger.bun.getName();
        float actualPrice = burger.bun.getPrice();
        boolean isActualSetBun = ((bunOne.getName().equals(actualName)) & (bunOne.getPrice() == actualPrice));
        Assert.assertEquals(IS_SET_BUN, isActualSetBun);
    }

}
