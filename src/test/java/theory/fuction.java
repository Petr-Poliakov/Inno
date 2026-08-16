package theory;

import org.junit.jupiter.api.Test;

public class fuction {
    //@Test
    public void test(){
        printFive(); //- метод ничего
        System.out.println(returnFive()); //- вывод в консоль метода возвращающий 5
        System.out.println(plus(2, 4)); //- вывод в консоль метода сложения 2х чисел
        System.out.println(AnotherClass.getHi()); // - вызов метода из класса в структуре theory.AnotherClass
        System.out.println(AnotherClass.capitall("help me")); // - вызов метода из класса в структуре theory.AnotherClass
    }

// метод  возвращает 5
    int returnFive(){
        return 5;
    }
// метод складывает два целых числа
    int plus(int a, int b){
        return a + b;
    }

// вызов метода
    void printFive(){
    }

}


