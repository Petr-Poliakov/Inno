import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DZ3 {
        DZ1 dz = new DZ1();

        // 1. Задача
        @Test
        @Tag("task1")
        @Tag("boolean")
        void testHasBug_DetectsBugMessage() {
            String[] messages = {"Info", "OK", "Bug", "Warning"};

            boolean actual = dz.hasBug(messages);

            assertThat(actual)
                    .as("hasBug(%s) должен вернуть true, т.к. в массиве есть сообщение \"Bug\"",
                            Arrays.toString(messages))
                    .isTrue();
        }

        @Test
        @Tag("task1")
        @Tag("list")
        void testRemoveSpecificName_RemovesGivenName() {
            List<String> input = Arrays.asList("Alice", "Bob", "Carol");
            List<String> expected = Arrays.asList("Alice", "Carol");

            List<String> actual = DZ1.removeSpecificName(input, "Bob");

            assertThat(actual)
                    .as("removeSpecificName(%s, \"Bob\")", input)
                    .isEqualTo(expected);
        }


        @Test
        @Tag("task1")
        void testSumToN_CalculatesCorrectSum() {
            int n = 10;
            int expected = 55;

            int actual = dz.sumToN(n);

            assertThat(actual)
                    .as("sumToN(%d)", n)
                    .isEqualTo(expected);
        }


        @Test
        @Tag("task1")
        @Tag("intentionally-failing")
        void testFindMax_IntentionallyWrongExpectation() {
            int[] arr = {3, 7, 2};
            int actual = dz.findMax(arr);
            int intentionallyWrongExpected = 100;

            assertThat(actual)
                    .as("findMax(%s) — тест специально сделан падающим",
                            Arrays.toString(arr))
                    .isEqualTo(intentionallyWrongExpected);
        }
}
