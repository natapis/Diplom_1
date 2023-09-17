import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerAddIngredientsTest {
    int sizeIngredientMassive;
    boolean isAdd;

    public BurgerAddIngredientsTest(int size, boolean isAdd) {
        this.sizeIngredientMassive = size;
        this.isAdd = isAdd;
    }

    @Parameterized.Parameters(name = "Добавлен ингредиент в массив размером {0} - {1}")
    public static Object[][] addIngredientsTest() {
        return new Object[][]{
                {0, true},
                {1, true},
        };
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Database data = new Database();
        if (sizeIngredientMassive >= 0) {
            for (int i = 0; i <= sizeIngredientMassive; i++) {
                Ingredient ingredientTest = data.availableIngredients().get(i);
                burger.addIngredient(ingredientTest);
            }
            boolean isActualAdd = (sizeIngredientMassive + 1 == burger.ingredients.size());
            Assert.assertEquals("size massive different", isAdd, isActualAdd);
        } else {
            boolean isActualAdd = false;
            System.out.println("Задан неверный размер массива");
            Assert.assertEquals(isAdd, isActualAdd);
        }
    }
}
