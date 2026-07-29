import java.util.Random;

public class randomizer {
    void randomeMethod(){
        Random random = new Random();
        int age = random.nextInt(0, 100);
        boolean actualResult = random.nextBoolean();

        System.out.println(age);
        
    }
}
