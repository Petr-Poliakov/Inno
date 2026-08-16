import static org.assertj.core.api.Assertions.assertThat;
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
public class DZ3_2 {
    DZ1 dz = new DZ1();
    static Random random = new Random();

    // Задача 2

    @RepeatedTest(10)
    @Tag("DZ3")
    @Tag("boolean")
    void testIsEven() {
        int n = random.nextInt(100) + 1;
        //System.out.println("Number = " + n);

        boolean extended = (n % 2 == 0);
        boolean actual = dz.isEven(n);

        assertThat(actual)
                .as("isEven(%d)", n)
                .isEqualTo(extended);

    }

    @RepeatedTest(10)
    @Tag("DZ3")
    void testisPositive() {
        int n = random.nextInt(-1000, 1000);
        //System.out.println("Number = " + n);
        boolean extended = (n >= 0);
        boolean actual = (dz.isPositive(n));

        assertThat(actual)
                .as("isPositive(%d)", n)
                .isEqualTo(extended);

    }

    @RepeatedTest(10)
    @Tag("DZ3")
    void testCheckAccess() {
        int age = random.nextInt(100);

        // Реальная логика DZ1.checkAccess: age > 18 (строго больше, 18 лет = "Denied")
        String expected = (age > 18) ? "Allowed" : "Denied";
        String actual = dz.checkAccess(age);

        assertThat(actual)
                .as("checkAccess(%d)", age)
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @Tag("DZ3")
    @MethodSource("randomScores")
    void testGetGrade(int score) {
        //System.out.println("Score = " + score);
        String expected = expectedGrade(score);
        String actual = dz.getGrade(score);
        assertThat(actual)
                .as("getGrade(%d)")
                .isEqualTo(expected);
    }
    private static String expectedGrade(int score) {
        if (score >= 0 && score <= 20) return "Score: E";
        if (score <= 40) return "Score: D";
        if (score <= 60) return "Score: C";
        if (score <= 80) return "Score: B";
        return "Score: A"; // 81..100
    }

    static IntStream randomScores() {
        return IntStream.generate(() -> random.nextInt(101)).limit(10);
    }


    @RepeatedTest(10)
    @Tag("DZ3")
    void testBlatOff() {
        int start = random.nextInt(5, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("Поехали!");
        String expected = sb.toString();

        String actual = dz.blastOff(start);

        assertThat(actual)
                .as("blastOff(%d)", start)
                .isEqualTo(expected);
    }


    @RepeatedTest(10)
    @Tag("DZ3")
    void testHasBug() {
        int size = random.nextInt(6) + 1;
        String[] pool = {"OK", "Info", "Warning", "Bug", "Error", "Debug"};
        String[] messages = new String[size];
        for (int i = 0; i < size; i++) {
            messages[i] = pool[random.nextInt(pool.length)];
        }

        boolean expected = Arrays.asList(messages).contains("Bug");
        boolean actual = dz.hasBug(messages);

        assertThat(actual)
                .as("hasBug(%s)", Arrays.toString(messages))
                .isEqualTo(expected);
    }

    @RepeatedTest(10)
    @Tag("DZ3")
    void testSumToN() {
        int n = random.nextInt(1000);

        int expected = n * (n + 1) / 2;
        int actual = dz.sumToN(n);

        assertThat(actual)
                .as("sumToN(%d)", n)
                .isEqualTo(expected);
    }

    @RepeatedTest(10)
    @Tag("DZ3")
    void testFindMax() {
        int size = random.nextInt(10) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }

        int expected = Arrays.stream(arr).max().getAsInt();
        int actual = dz.findMax(arr);

        assertThat(actual)
                .as("findMax(%s)", Arrays.toString(arr))
                .isEqualTo(expected);
    }

    @RepeatedTest(10)
    @Tag("DZ3")
    void testCalcAverage() {
        int size = random.nextInt(10) + 1;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int val = random.nextInt(201);
            list.add(val);
            sum += val;
        }

        int expected = sum / size;
        int actual = dz.calcAverage(list);

        assertThat(actual)
                .as("calcAverage(%s)", list)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @Tag("DZ3")
    @MethodSource("reverseData")
    void testReverse(String[] input, String[] expected) {
        String[] actual = dz.reverse(input);

        assertThat(actual)
                .as("reverse(%s)", Arrays.toString(input))
                .containsExactly(expected);
    }

    // расширено до 10 наборов данных для выполнения требования ">= 10 раз"
    static Stream<Arguments> reverseData() {
        return Stream.of(
                Arguments.of(new String[]{"a", "b", "c"}, new String[]{"c", "b", "a"}),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"3", "2", "1"}),
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(new String[]{"one", "two", "three", "four"}, new String[]{"four", "three", "two", "one"}),
                Arguments.of(new String[]{"m", "n"}, new String[]{"n", "m"}),
                Arguments.of(new String[]{"p", "q", "r", "s", "t"}, new String[]{"t", "s", "r", "q", "p"}),
                Arguments.of(new String[]{"single"}, new String[]{"single"}),
                Arguments.of(new String[]{"A", "B", "C"}, new String[]{ "C", "B", "A"}),
                Arguments.of(new String[]{"D", "E", "F"}, new String[]{"F", "E", "D"}),
                Arguments.of(new String[]{ "4", "5", "6", "7"}, new String[]{"7", "6", "5", "4", })
        );
    }

    @ParameterizedTest
    @Tag("DZ3")
    @CsvSource({
            "1, 10, '2 4 6 8 10'",
            "5, 5, ''",
            "-4, 4, '-4 -2 0 2 4'",
            "10, 1, ''",
            "2, 2, '2'",
            "0, 0, '0'",
            "-10, -1, '-10 -8 -6 -4 -2'",
            "7, 7, ''",
            "100, 105, '100 102 104'",
            "-3, 3, '-2 0 2'"
    })
    void testGetEvenInRange(int start, int end, String evenRange) {
        String actual = dz.getEvenInRange(start, end);

        assertThat(actual)
                .as("getEvenInRange(%d, %d)", start, end)
                .isEqualTo(evenRange);
    }

    @ParameterizedTest
    @Tag("DZ3")
    @Tag("list")
    @CsvSource({
            "'Alice;Bob;Carol', Bob, 'Alice;Carol'",
            "'Alice;Bob;Carol', Dave, 'Alice;Bob;Carol'",
            "'Alice', Alice, ''",
            "'Anna;Anna;Boris', Anna, 'Anna;Boris'",
            "'X;Y;Z', Y, 'X;Z'",
            "'', Alice, ''",
            "'One;Two', Three, 'One;Two'",
            "'A;B;C;D', D, 'A;B;C'",
            "'Same;Same;Same', Same, 'Same;Same'",
            "'Q', Q, ''"
    })
    void testRemoveSpecificName(String inputCsv, String nameToRemove, String expectedCsv) {
        List<String> input = splitToList(inputCsv);
        List<String> expected = splitToList(expectedCsv);
        List<String> actual = dz.removeSpecificName(input, nameToRemove);

        assertThat(actual)
                .as("removeSpecificName(%s, \"%s\")", input, nameToRemove)
                .isEqualTo(expected);
    }

    private List<String> splitToList(String csvField) {
        if (csvField == null || csvField.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(csvField.split(";")));
    }

}