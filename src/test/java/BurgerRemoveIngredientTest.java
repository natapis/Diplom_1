import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

@RunWith(Parameterized.class)

public class BurgerRemoveIngredientTest {
    int sizeIngredientMassive;
    int index;
    boolean isRemove;

    public BurgerRemoveIngredientTest(int size, int index, boolean isRemove) {
        this.sizeIngredientMassive = size;
        this.isRemove = isRemove;
        this.index = index;
    }

    @Parameterized.Parameters(name = "Удален ингредиент из массива размером {0} с индексом {1} - {2}")
    public static Object[][] removeIngredientsTest() {
        return new Object[][]{
                {1, 0, true},
                {5, 0, true},
                {5, 2, true},
                {5, 4, true},
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
        Assert.assertEquals("size massive different", isRemove, isActualRemove);
    }
}
