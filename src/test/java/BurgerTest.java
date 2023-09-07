import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Test", 203);
    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        IngredientType actualType = burger.ingredients.get(0).getType();
        String actualName = burger.ingredients.get(0).getName();
        float actualPrice = burger.ingredients.get(0).getPrice();
        Assert.assertEquals(203, actualPrice, 0);
        Assert.assertEquals("Не добавилось имя", "Test", actualName);
        Assert.assertEquals(IngredientType.FILLING, actualType);
        Assert.assertEquals(false, burger.ingredients.isEmpty());
    }
}
