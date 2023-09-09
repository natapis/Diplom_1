import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
// Понять нужны ли тесты для массива с нулевым размером, или можно ли удалить элемент с индексом большего размера
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
                {0, 0, false},
                {1, 0, true},
                {1, 1, false},
                {5, 0, true},
                {5, 2, true},
                {5, 4, true},
        };
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        for (int i = 0; i < sizeIngredientMassive; i++) {
            Ingredient ingredientTest = new Ingredient(IngredientType.FILLING, "Test" + i, 23 + i);
            burger.addIngredient(ingredientTest);
        }
        burger.removeIngredient(index);
        boolean isActualRemove = (sizeIngredientMassive - 1 == burger.ingredients.size());
        Assert.assertEquals("size massive different", isRemove, isActualRemove);
    }
}
