import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientParametersTest {
    private int sizeIngredientMassive;
    private int index;
    private int newIndex;
    boolean isMove;

    public BurgerMoveIngredientParametersTest(int sizeOne, int index, int newIndex, boolean isMove) {
        this.sizeIngredientMassive = sizeOne;
        this.index = index;
        this.newIndex = newIndex;
        this.isMove = isMove;
    }

    @Parameterized.Parameters(name = "Перемещение в массиве размером {0} c {1}-го на {2}-е место = {3}")
    public static Object[][] burgerMoveIngredient() {
        return new Object[][]{
                {1, 0, 1, false},
                {2, 0, 1, true},
                {2, 1, 0, true},
                {2, 1, 1, true},
                {0, 0, 1, false},
                {3, 0, 2, true},
                {3, 2, 0, true},
        };
    }

    @Test
    public void moveIngredientTest() {
        if (sizeIngredientMassive > 1) {
            Burger burger = new Burger();
            for (int i = 0; i <= sizeIngredientMassive - 1; i++) {
                Ingredient ingredientTest = new Ingredient(IngredientType.FILLING, "Test" + i, 23 + i);
                burger.addIngredient(ingredientTest);
            }
            int actualSize = burger.ingredients.size();
            Ingredient ingredient = burger.ingredients.get(index);
            burger.moveIngredient(index, newIndex);
            int actualIndex = burger.ingredients.indexOf(ingredient);
            isMove = ((newIndex == actualIndex) && (sizeIngredientMassive == actualSize));
            Assert.assertEquals("Индексы не совпадают", isMove, true);
        } else {
            System.out.println("Move impossible");
            isMove = false;
        }
    }
}
