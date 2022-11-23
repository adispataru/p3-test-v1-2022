import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Animal;
import ro.uvt.p3.testv1.RoboZooKeeper;
import ro.uvt.p3.testv1.Mammal;
import ro.uvt.p3.testv1.Food;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboKeeperTest {

    @Test
    public void testConstructorAndGetters(){
        RoboZooKeeper keeper = new RoboZooKeeper("Timisoara", 200);

        for(Food i : Food.values()){
            assertEquals(5000, keeper.getStock(i), "stock not initialized");
        }

        List<Food> ingredients = new ArrayList<>();
        ingredients.add(Food.FRUIT);
        ingredients.add(Food.CEREALS);

        Animal a1 = new Mammal("Maxy", ingredients, 120);
        a1.setDailyAmount(Food.FRUIT, 100);
        a1.setDailyAmount(Food.CEREALS, 60);

        keeper.addAnimal(a1);

        Animal a2 = new Animal("Hexy", ingredients);
        keeper.addAnimal(a2);

        assertEquals(a1, keeper.getAnimals().get(0));
        assertEquals(a2, keeper.getAnimals().get(1));
    }
}
