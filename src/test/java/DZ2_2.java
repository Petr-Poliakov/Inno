import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DZ2_2 {

    DZ1 dz = new DZ1();
    static Random random = new Random();

    // Задача 2

    @Test
    @Tag("DZ1")
    void testIsEven() {
        int n = random.nextInt(100) + 1;
        System.out.println("Number = " + n);
        if (dz.isEven(n) == true) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    @Tag("DZ1")
    void testisPositive() {
        int n = random.nextInt(-1000, 1000);
        System.out.println("Number = " + n);
        if (dz.isPositive(n) == true) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(3)
    @Tag("DZ1")
    void testCheckAccess() {
        int age = random.nextInt(100);
        System.out.println("Age = " + age);
        if (dz.checkAccess(age) == "Allowed") {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @Tag("DZ1")
    @MethodSource("randomScores")
    void testGetGrade(int score) {
        System.out.println("Score = " + score);
        if (dz.getGrade(score) == "Score: E" && (score >= 0) && (score <= 20)) {
            System.out.println("TEST PASSED");
        } else if (dz.getGrade(score) == "Score: D" && (score >= 21) && (score <= 40)) {
            System.out.println("TEST PASSED");
        } else if (dz.getGrade(score) == "Score: C" && (score >= 41) && (score <= 60)) {
            System.out.println("TEST PASSED");
        } else if (dz.getGrade(score) == "Score: B" && (score >= 61) && (score <= 80)) {
            System.out.println("TEST PASSED");
        } else if (dz.getGrade(score) == "Score: A" && (score >= 81) && (score <= 100)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    static IntStream randomScores() {
        return IntStream.generate(() -> random.nextInt(101)).limit(10);
    }


    @Test
    @Tag("DZ1")
    void testBlatOff() {
        int start = random.nextInt(5, 10);
        System.out.println("До старта осталось " + start + " секунд");
        System.out.println(dz.blastOff(start));
        if (dz.blastOff(start) == dz.blastOff(start)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");

        }
    }

    @RepeatedTest(3)
    @Tag("DZ1")
    void testHasBug() {
        int size = random.nextInt(6) + 1;
        String[] pool = {"OK", "Info", "Warning", "Bug", "Error", "Debug"};
        String[] messages = new String[size];
        for (int i = 0; i < size; i++) {
            messages[i] = pool[random.nextInt(pool.length)];
        }
        boolean expected = Arrays.asList(messages).contains("Bug");
        System.out.println(Arrays.toString(messages));
        if (expected == true) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    @Tag("DZ1")
    void testSumToN() {
        int n = random.nextInt(1000);
        int actual = dz.sumToN(n);
        System.out.println(n);
        if (actual == dz.sumToN(n)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    @Tag("DZ1")
    void testFindMax() {
        int size = random.nextInt(10) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }
        int expected = Arrays.stream(arr).max().getAsInt();
        int actual = dz.findMax(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("MAX = " + dz.findMax(arr));
        if (actual == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    @Tag("DZ1")
    void testCalcAverage() {
        int size = random.nextInt(10) + 1; //
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int val = random.nextInt(201);
            list.add(val);
            sum += val;
        }
        int result = sum / size;
        int actual = dz.calcAverage(list);
        System.out.println(list);
        System.out.println(result);
        if (actual == result) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @Tag("DZ1")
    @MethodSource("reverseData")
    void testReverse(String[] input, String[] expected) {
        String[] actual = dz.reverse(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(expected));
        if (Arrays.equals(actual, expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    static Stream<Arguments> reverseData() {
        return Stream.of(
                Arguments.of(new String[]{"a", "b", "c"}, new String[]{"c", "b", "a"}),
                Arguments.of(new String[]{"x"}, new String[]{"x"}),
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(new String[]{"one", "two", "three", "four"}, new String[]{"four", "three", "two", "one"})
        );
    }

    @ParameterizedTest
    @Tag("DZ1")
    @CsvSource({
            "1, 10, '2 4 6 8 10'",
            "5, 5, ''",
            "-4, 4, '-4 -2 0 2 4'",
            "10, 1, ''",
            "2, 2, '2'"
    })
    void testGetEvenInRange(int start, int end, String evenRange) {
        String actual = dz.getEvenInRange(start, end);
        System.out.println("Начало" + start + ", Конец " + end);
        System.out.println(evenRange);
        if (actual.equals(evenRange)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }
    @ParameterizedTest
    @Tag("DZ1")
    @CsvSource({
            "'Alice;Bob;Carol', Bob, 'Alice;Carol'",
            "'Alice;Bob;Carol', Dave, 'Alice;Bob;Carol'",
            "'Alice', Alice, ''",
            "'Anna;Anna;Boris', Anna, 'Anna;Boris'"
    })
    void testRemoveSpecificName(String inputCsv, String nameToRemove, String expectedCsv) {
        List<String> input = splitToList(inputCsv);
        List<String> expected = splitToList(expectedCsv);
        List<String> actual = dz.removeSpecificName(input, nameToRemove);
        System.out.println("Список" + input + ", удалить=" + nameToRemove);
        System.out.println("Результат после удаления " + expectedCsv);
        if (actual.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }
    private List<String> splitToList(String csvField) {
        if (csvField == null || csvField.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(csvField.split(";")));
    }

}




