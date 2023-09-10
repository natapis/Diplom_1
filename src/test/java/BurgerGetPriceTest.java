import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;
    public BurgerGetPriceTest(Bun bun, List<Ingredient> ingredients, float expectedPrice){
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters(name="Цена бургера с булочкой {0} и количеством ингредиентов {1} = {2}")
    public static Object[][] priceTest(){
        return new Object[][]{
                {new Bun("black bun", 100), Arrays.asList(), 200},
                {new Bun("white bun", 200), Arrays.asList(new Ingredient(IngredientType.SAUCE, "hot sauce", 100)), 500},
                {new Bun("red bun", 300), Arrays.asList(new Ingredient(IngredientType.FILLING, "dinosaur", 200), new Ingredient(IngredientType.SAUCE, "hot sauce", 100)), 900},
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i=0; i<ingredients.size(); i++){
            burger.addIngredient(ingredients.get(i));
        }
        float actualPriceBurger = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPriceBurger, 0);

    }
}
