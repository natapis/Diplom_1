import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

@RunWith(Parameterized.class)

public class BurgerRemoveIngredientTest {
    private int sizeIngredientMassive;
    private int index;
    private final boolean IS_REMOVE = true;

    public BurgerRemoveIngredientTest(int size, int index) {
        this.sizeIngredientMassive = size;
        this.index = index;
    }

    @Parameterized.Parameters(name = "Удален ингредиент из массива размером {0} с индексом {1} - {2}")
    public static Object[][] removeIngredientsTest() {
        return new Object[][]{
                {1, 0},
                {5, 0},
                {5, 2},
                {5, 4},
        };
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Database data = new Database();
        for (int i = 0; i < sizeIngredientMassive; i++) {
            Ingredient ingredientTest = data.availableIngredients().get(i);
            burger.addIngredient(ingredientTest);
        }
        burger.removeIngredient(index);
        boolean isActualRemove = (sizeIngredientMassive - 1 == burger.ingredients.size());
        Assert.assertEquals("size massive different", IS_REMOVE, isActualRemove);
    }
}
