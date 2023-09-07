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
    private Ingredient ingredientTest;
    private Bun bun = new Bun("TestBun", 567);
    @Test
    public void addIngredientTest(){
        int numberIngredient = 5;
        Burger burger = new Burger();
        for (int i=0; i <= numberIngredient; i++){
            ingredientTest = new Ingredient(IngredientType.FILLING,"Test" + i, 23+i);
            burger.addIngredient(ingredientTest);
        }
 //       burger.addIngredient(ingredient);
 //       IngredientType actualType = burger.ingredients.get(0).getType();
 //       String actualName = burger.ingredients.get(0).getName();
 //       float actualPrice = burger.ingredients.get(0).getPrice();
 //       Assert.assertEquals(203, actualPrice, 0);
 //       Assert.assertEquals("Не добавилось имя", "Test", actualName);
//        Assert.assertEquals(IngredientType.FILLING, actualType);
        Assert.assertEquals(false, burger.ingredients.isEmpty());
        Assert.assertEquals(true,burger.ingredients.contains(ingredientTest));
        Assert.assertEquals(numberIngredient, burger.ingredients.indexOf(ingredientTest));
        Assert.assertEquals(numberIngredient+1, burger.ingredients.size());
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
        int index = 1;
        int indexNew = 3;
        Burger burger = new Burger();
        for (int i=0; i <= indexNew; i++){
            ingredientTest = new Ingredient(IngredientType.FILLING,"Test" + i, 23+i);
            burger.addIngredient(ingredientTest);
        }
 //       burger.addIngredient(ingredient);
 //       burger.addIngredient(ingredientTwo);
        int actualSize = burger.ingredients.size();
        ingredientTwo = burger.ingredients.get(index);
        burger.moveIngredient(index,indexNew);
        int actualIndex = burger.ingredients.indexOf(ingredientTwo);
//        int actualIndexTwo = burger.ingredients.indexOf(ingredientTwo);
        Assert.assertEquals(indexNew, actualIndex, 0);
 //       Assert.assertEquals(0, actualIndexTwo, 0);
        Assert.assertEquals(indexNew+1, actualSize, 0);
    }
}
