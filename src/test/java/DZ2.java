import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;

public class DZ2 {

    DZ1 dz = new DZ1();
    static Random random = new Random();

    // Задача 1
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
    @Test
    @Tag("DZ1")
    void testIsEven() {
        int n = random.nextInt(100) + 1;
        System.out.println("Number = " + n);
        System.out.println(dz.isEven(n));
    }

    @RepeatedTest(20)
    @Tag("DZ1")
    void testCheckAccess() {
        int age = random.nextInt(100);
        System.out.println("Age = " + age);
        System.out.println(dz.checkAccess(age));;
    }

    @ParameterizedTest
    @Tag("DZ1")
    @MethodSource("randomScores")
    void testGetGrade(int score) {
       System.out.println("Score = " + score);
       System.out.println(dz.getGrade(score));
    }

   static IntStream randomScores() {
        return IntStream.generate(() -> random.nextInt(101)).limit(10);
    }


    // Задача 2

}