import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;
@RunWith(Parameterized.class)
public class BurgerReceiptTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;

    public BurgerReceiptTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters(name = "Чек для бургера с булочкой {0} и количеством ингредиентов {1} = {2}")
    public static Object[][] priceTest() {
        return new Object[][]{
                {new Bun("black bun", 100),
                        Arrays.asList(),
                        String.format("(==== %s ====)%n(==== %s ====)%n%nPrice: %s%n", "black bun","black bun", "200,000000")},
                {new Bun("white bun", 200),
                        Arrays.asList(new Ingredient(IngredientType.SAUCE, "hot sauce", 100)),
                        String.format("(==== %s ====)%n= %s =%n(==== %s ====)%n%nPrice: %s%n", "white bun", "sauce hot sauce", "white bun", "500,000000")},
                {new Bun("red bun", 300),
                        Arrays.asList(new Ingredient(IngredientType.FILLING, "dinosaur", 200), new Ingredient(IngredientType.SAUCE, "hot sauce", 100)),
                        String.format("(==== %s ====)%n= %s =%n= %s =%n(==== %s ====)%n%nPrice: %s%n", "red bun", "filling dinosaur", "sauce hot sauce", "red bun", "900,000000")},
        };
    }

    ;

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < ingredients.size(); i++) {
            burger.addIngredient(ingredients.get(i));
        }
        String actualBurgerReceipt = burger.getReceipt();
        Assert.assertEquals("Чеки не совпадают", expectedReceipt, actualBurgerReceipt);
    }
}
