package theory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    //метод инициализации драйвера и открытие урла
    void setup (){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080"); //образение к урл выполненно , поэтому к в тестах уже можено обращаться к элеементам
    }



    @Test
    void driverTest(){
        driver.findElement(By.xpath("//*[@data-action=\"qty-change\"][@data-step =1][@data-id=10]")).click();
        Assertions.assertThat(driver.findElement(By.id("q-10")).getText())
                .as("Поле количество товара должно быть равно 2")
                .isEqualTo("2");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
