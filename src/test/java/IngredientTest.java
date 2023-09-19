import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private IngredientType typeIngredient = IngredientType.SAUCE;
    private String nameIngredient = "Соус традиционный галактический";
    private float priceIngredient = 15;

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        String actualName = ingredient.getName();
        Assert.assertEquals("Имена ингредиентов не совпадают", nameIngredient, actualName);
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(priceIngredient, actualPrice, 0);
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(typeIngredient, actualType);
    }
}
