import org.junit.jupiter.api.Test;

public class if_else_ternary {
@Test
    void printTest(){
    int x = 6;
    int y = 1;
    int score = 40;

/*    if(x > y){
        System.out.println("Bigger!");
    } else if (x < y){
        System.out.println("Lower!");
    } else {
        System.out.println("equel!");
    }*/

/*    if ((x > y) && (y > 2)){
        System.out.println("Bigger!");
    } else if (x <= y){
        System.out.println("Lower!");
}*/

    String ternaryStatus = (score >= 50)? "Сдал" : "не сдал";
    System.out.println("Результат тернарика: " + ternaryStatus);

}
}
