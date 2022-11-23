import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Animal;
import ro.uvt.p3.testv1.Mammal;
import ro.uvt.p3.testv1.Food;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MammalTest {

    @Test
    public void testConstructorandGetters(){
        List<Food> ingredients = new ArrayList<>();
        ingredients.add(Food.MEAT);
        ingredients.add(Food.WATER);

        Mammal mam = new Mammal("Maxy", ingredients, 66);
        mam.setDailyAmount(Food.MEAT, 300);
        mam.setDailyAmount(Food.WATER, 180);

        assertEquals("Maxy", mam.getName(), "wrong name");
        assertEquals(Food.MEAT, mam.getFoods().get(0), "wrong ingredient 0");
        assertEquals(Food.WATER, mam.getFoods().get(1), "wrong ingredient 1");
        assertEquals(300, mam.getDailyAmount(Food.MEAT), "wrong amount for ingredient");
        assertEquals(180, mam.getDailyAmount(Food.WATER), "wrong amount for ingredient");

        assertEquals(66, mam.getGestationPeriod(), "wrong gestation period");

        assertInstanceOf(Animal.class, mam);
    }
}
