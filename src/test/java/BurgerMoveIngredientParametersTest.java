import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

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
                {1, 0, 0, true},
                {2, 0, 1, true},
                {2, 1, 0, true},
                {3, 0, 2, true},
                {3, 2, 0, true},
                {5, 1, 3, true},
                {5, 3, 1, true},
        };
    }

    @Test
    public void moveIngredientTest() {
        if ((sizeIngredientMassive > 1) || ((sizeIngredientMassive == 1) & (index == newIndex))) {
            Burger burger = new Burger();
            Database data = new Database();
            for (int i = 0; i <= sizeIngredientMassive - 1; i++) {
                Ingredient ingredientTest = data.availableIngredients().get(i);
                burger.addIngredient(ingredientTest);
            }
            int actualSize = burger.ingredients.size();
            Ingredient ingredient = burger.ingredients.get(index);
            burger.moveIngredient(index, newIndex);
            int actualIndex = burger.ingredients.indexOf(ingredient);
            boolean isActualMove = ((newIndex == actualIndex) && (sizeIngredientMassive == actualSize));
            Assert.assertEquals("Индексы не совпадают", isMove, isActualMove);
        } else {
            System.out.println("Move impossible");
            boolean isActualMove = false;
            Assert.assertEquals("Индексы не совпадают", isMove, isActualMove);
        }
    }
}
