import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerAddIngredientsTest {
    private int sizeIngredientMassive;
    private final boolean IS_ADD = true;
    @Mock
    Database data;

    public BurgerAddIngredientsTest(int size) {
        this.sizeIngredientMassive = size;
    }

    @Parameterized.Parameters(name = "Добавлен ингредиент в массив размером {0}")
    public static Object[][] addIngredientsTest() {
        return new Object[][]{
                {0},
                {1},
        };
    }
    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        List<Ingredient> list = new ArrayList<>();
        Mockito.when(data.availableIngredients()).thenReturn(list);
        if (sizeIngredientMassive >= 0) {
            for (int i = 0; i <= sizeIngredientMassive; i++) {
                list.add(ingredient);
                Ingredient ingredientTest = data.availableIngredients().get(i);
                burger.addIngredient(ingredientTest);
            }
            boolean isActualAdd = (sizeIngredientMassive + 1 == burger.ingredients.size());
            Assert.assertEquals("size massive different", IS_ADD, isActualAdd);
        } else {
            boolean isActualAdd = false;
            System.out.println("Задан неверный размер массива");
            Assert.assertEquals(IS_ADD, isActualAdd);
        }
    }
}
