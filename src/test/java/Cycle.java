import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Cycle {
    @Test
    void printTest() {
        String[] flowers = {"Rose", "Fial", "Sunflower"};
        flowers[0] = "Blueflower";

        String[] berries = new String[10];
        berries[0] = "raspberry";
        berries[1] = "blueberry";
        berries[2] = "blackberry";

        System.out.println(flowers[0]);
        System.out.println(flowers[0] + " " + flowers[1] + " " + flowers[2]);
        System.out.println(berries[0] + " " + berries[1] + " " + berries[2]);

    }
}