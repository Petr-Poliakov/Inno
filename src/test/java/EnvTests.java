import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;


public class EnvTests {
    public boolean isNotEven(int value){
        return !(value % 2 == 0);
    }

   // @Test
    @Tag("Smoke")
    void envTest1(){
        System.out.println(System.getProperty("CIRCUIT"));
    }


    @ParameterizedTest
    @ValueSource(ints ={0, 1, 2, 1000, 1001})
    void isNotEvenTest(int value){
        System.out.println("Test with value = " + value );
        if (isNotEven(value) == true){
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        }
    }

    @ParameterizedTest
    @CsvSource({"0, true", "1, true", "2, false", "1000, false","1001, true"})
    void isNotEvenSecondeTest(int value, boolean expectedResult){
        System.out.println("Test with value = " + value );
        if (isNotEven(value) == expectedResult){
            System.out.println("PASSED!");
        }
        else {
            System.out.println("FAILED");
        }
    }

    @ParameterizedTest
    @EnumSource(value = Role.class /*,names = {"Admin"}*/) // если стереть name, то запуститься со всеми роялми в классе
    void roleTest(Role role){
        switch (role){
            case Admin -> {
                System.out.println("Login as Admin");
            }
            case Tester -> {
                System.out.println("Login as Tester");
            }
            case Observed -> {
                System.out.println("Can't  run test as Observed");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void TenDivTest(int  value){
        System.out.println(value%10);
    }

    static List<Integer> getTestData(){
        return List.of(25,31,44,58);
    }

    static List<Map<String, Integer>> getTestDataWithExpectedResult(){
        return List.of(
                Map.of("True", 11),
                Map.of("False", 13)
                );
            }

}