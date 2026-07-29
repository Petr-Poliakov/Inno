import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestMain {
    // метод для ДЗ#2

    private static final Random random = new Random();

    @BeforeEach
    void beforeEach() {
        System.out.println("========================");
        System.out.println("Test method start");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test method end");
        System.out.println("========================");
    }
   // @Test
    void startAllTests(){
        //equals();
    }

    }

