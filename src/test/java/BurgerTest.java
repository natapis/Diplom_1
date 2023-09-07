import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    private Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Test", 203);
    private Bun bun = new Bun("TestBun", 567);
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

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        String actualName = burger.bun.getName();
        float actualPrice = burger.bun.getPrice();
        Assert.assertEquals(567, actualPrice,0);
        Assert.assertEquals("TestBun", actualName);
        ;
    }
}
