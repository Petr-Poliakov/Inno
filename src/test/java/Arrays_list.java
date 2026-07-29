import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Arrays_list {
   // @Test
    void printTest(){
        String[] flowers = {"Rose","Fial","Sunflower"};
        flowers[0] = "Blueflower";

        String[] berries = new String[10];
        berries[0] = "raspberry";
        berries[1] = "blueberry";
        berries[2] = "blackberry";

        System.out.println(flowers[0]);
        System.out.println(flowers[0] +" "+ flowers[1]+" "+ flowers[2]);
        System.out.println(berries[0] +" "+ berries[1]+" "+ berries[2]);

    }

    //@Test
    void printTestArrayList(){
        List<String> flowers = List.of("Rose","Fial","Sunflower");
        System.out.println(flowers.get(0) +" "+ flowers.get(1)+" "+ flowers.get(2));

        List<String> berries = new ArrayList<>();
        berries.add(0, "raspberry");
        berries.add(1, "blueberry");
        berries.add("wildberry");
        berries.add(2, "blackberry");

        if(berries.contains("wildberry")){
            System.out.println("Wildberry is here!");
        }

        System.out.println(berries.get(0) +" "+ berries.get(1)+" "+ berries.get(2)+" "+ berries.get(3));
    }
}
