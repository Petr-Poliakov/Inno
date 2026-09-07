package DZ5;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class DZ5_1_2 {
    WebDriver driver;

    private static final String BASE_URL = "http://localhost:8080";
    String productName = "Учебник JS";
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();

    }

    @Test
    void addToCart_() {

        //авторизация
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("secret123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.get(BASE_URL + "/admin");
        driver.findElement(By.id("n-name")).sendKeys(productName);
        driver.findElement(By.id("n-price")).sendKeys("50");
        driver.findElement(By.id("add-btn")).click();

        driver.get(BASE_URL + "/");
        driver.findElement(By.cssSelector(".product-card[data-name='Учебник JS'] button[data-action='add-to-cart']")).click();

        //переход в корзину
        driver.findElement(By.id("open-cart-btn")).click();

        List<String> cartItemNames = driver.findElements(By.cssSelector("#cart-items .cart-item b"))
                .stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());

        Assertions.assertThat(cartItemNames)
                .as("В корзине должен отображаться добавленный товар \"Учебник JS\"")
                .contains("Учебник JS");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
