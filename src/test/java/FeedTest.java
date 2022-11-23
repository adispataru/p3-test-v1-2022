import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Animal;
import ro.uvt.p3.testv1.RoboZooKeeper;
import ro.uvt.p3.testv1.Mammal;
import ro.uvt.p3.testv1.Food;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeedTest {

    @Test
    public void testFeedMachine(){
        RoboZooKeeper robo = new RoboZooKeeper("RoZoo5520", 10000);

        List<Food> ingredients = new ArrayList<>();
        ingredients.add(Food.FRUIT);
        ingredients.add(Food.FISH);

        Animal a1 = new Animal("Vely", ingredients);
        a1.setDailyAmount(Food.FRUIT, 100);
        a1.setDailyAmount(Food.FISH, 60);

        robo.addAnimal(a1);


        boolean result = robo.feed(0);
        assertTrue(result, "robot should be able to feed");
        assertEquals(5000 - 100, robo.getStock(Food.FRUIT), "fruit should be subtracted");
        assertEquals(5000 - 60, robo.getStock(Food.FISH), "fish should be subtracted");
        assertEquals(8400, robo.getChargeLeft(), "charge must be subtracted");


        List<Food> ingredients2 = new ArrayList<>();
        ingredients2.add(Food.MEAT);
        ingredients2.add(Food.WATER);
        ingredients2.add(Food.LEAVES);

        Mammal a2 = new Mammal("Celu", ingredients2, 122);
        a2.setDailyAmount(Food.MEAT, 60);
        a2.setDailyAmount(Food.WATER, 200);
        a2.setDailyAmount(Food.LEAVES, 80);

        robo.addAnimal(a2);

        result = robo.feed(1);
        assertTrue(result, "robo should be able to feed");
        assertEquals(1600,robo.getChargeLeft(), "wrong charge left");

        result = robo.feed(1);
        assertFalse(result, "robo shouldn't be able to feed due to charge");

        result = robo.feed(0);
        assertTrue(result, "robo should to feed first animal");
        assertEquals(0,robo.getChargeLeft(), "wrong charge left");
        

    }
}
