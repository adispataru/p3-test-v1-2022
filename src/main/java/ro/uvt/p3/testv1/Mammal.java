package ro.uvt.p3.testv1;

import java.util.List;

public class Mammal extends Animal{


    public Mammal(String name, List<Food> foods, int gestationPeriod) {
        super(name, foods);
    }

    public int getGestationPeriod() {
        return 0;
    }
}
