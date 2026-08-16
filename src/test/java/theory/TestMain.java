package theory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TestMain {
   @Test
   public void test() {

       ////пример на применения встроенного в Java
       // File someFile = new File("1.txt");
       //String[] strings = someFile.list();

       // не проверяемое исключение
       //пример на применения
     /*  try {
           for (String str : strings) {
               System.out.println(str);
           }
       }
       catch(NullPointerException ex) {
               System.out.println(ex.getMessage());
           }
       }*/


       // проверяемое  исключение
       //пример на применения
/*       try {
           new FileReader(someFile).read();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       System.out.println("End of code");
   }*/

       // Assert in JUnit
       //пример на применения
       /*Integer dig = new Random().nextInt(1, 10);
       Integer expectedResult = 3;

       // проверка на равенство Assert dig.equals (expectedResult)
       Assertions.assertEquals(expectedResult, dig);*/

       //AsserJ
       //пример на применения
        Random randomAnother =  new Random();
        Integer actualResult = randomAnother.nextInt(1,10);
        Integer expectedBound = 5;

/*        for(int i = 0; i<10; i++){
            actualResult=actualResult + randomAnother.nextInt(20,70);
        }*/
       Assertions.assertThat(actualResult)
               .as("String must be equals")
                       .isLessThan(expectedBound);

       //добавим JUnit для сравнеия выводы Assert коментировать один или другой для демонстрации
       org.junit.jupiter.api.Assertions.assertTrue(actualResult<expectedBound);
       }






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

    }

