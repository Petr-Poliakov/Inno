import org.junit.jupiter.api.Test;

public class AnotherClass{
    @Test
    void test(){
        TestMain testMain = new TestMain();
    }

    public static String getHi(){
        return "Hi!";
    }

    public static String capitall(String text){
        return text.toUpperCase();
    }
}