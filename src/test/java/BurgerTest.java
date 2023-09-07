import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    private Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Test", 203);
    private Ingredient ingredientTwo = new Ingredient(IngredientType.SAUCE,"Test2", 209);
    private Bun bun = new Bun("TestBun", 567);
    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
 //       IngredientType actualType = burger.ingredients.get(0).getType();
 //       String actualName = burger.ingredients.get(0).getName();
 //       float actualPrice = burger.ingredients.get(0).getPrice();
 //       Assert.assertEquals(203, actualPrice, 0);
 //       Assert.assertEquals("Не добавилось имя", "Test", actualName);
//        Assert.assertEquals(IngredientType.FILLING, actualType);
        Assert.assertEquals(false, burger.ingredients.isEmpty());
        Assert.assertEquals(true,burger.ingredients.contains(ingredient));
    }

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        String actualName = burger.bun.getName();
        float actualPrice = burger.bun.getPrice();
        Assert.assertEquals(567, actualPrice,0);
        Assert.assertEquals("TestBun", actualName);
    }
    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
//        int size = burger.ingredients.size();
//        if (size != 0){
            burger.ingredients.remove(0);
//        }
//        int actualSize = burger.ingredients.size();
//        Assert.assertEquals(size-1, actualSize, 0);
        Assert.assertEquals(false, burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        int actualSize = burger.ingredients.size();
        burger.moveIngredient(0,1);
        int actualIndexOne = burger.ingredients.indexOf(ingredient);
        int actualIndexTwo = burger.ingredients.indexOf(ingredientTwo);
        Assert.assertEquals(1, actualIndexOne, 0);
        Assert.assertEquals(0, actualIndexTwo, 0);
        Assert.assertEquals(2, actualSize, 0);
    }
}
