import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Animal;
import ro.uvt.p3.testv1.Food;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void testConstructorandGetters(){
        List<Food> ingredients = new ArrayList<>();
        ingredients.add(Food.FRUIT);
        ingredients.add(Food.FISH);
        ingredients.add(Food.CEREALS);

        Animal a = new Animal("Hexy", ingredients);
        a.setDailyAmount(Food.FRUIT, 50);
        a.setDailyAmount(Food.FISH, 20);
        a.setDailyAmount(Food.CEREALS, 20);

        assertEquals("Hexy", a.getName(), "wrong name");
        assertEquals(Food.FRUIT, a.getFoods().get(0), "wrong ingredient 0");
        assertEquals(Food.FISH, a.getFoods().get(1), "wrong ingredient 1");
        assertEquals(Food.CEREALS, a.getFoods().get(2), "wrong ingredient 2");
        assertEquals(50, a.getDailyAmount(Food.FRUIT), "wrong amount for ingredient");
        assertEquals(20, a.getDailyAmount(Food.FISH), "wrong amount for ingredient");
        assertEquals(20, a.getDailyAmount(Food.CEREALS), "wrong amount for ingredient");

    }
}
