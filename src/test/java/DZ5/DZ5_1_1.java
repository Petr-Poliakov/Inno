package DZ5;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
public class DZ5_1_1 {
    WebDriver driver;

    private static final String BASE_URL = "http://localhost:8080";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void addProductViaAdmin() {
        String productName = "Учебник JAVA";

        //авторизация
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("secret123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //добавление товара
        driver.get(BASE_URL + "/admin");
        driver.findElement(By.id("n-name")).sendKeys(productName);
        driver.findElement(By.id("n-price")).sendKeys("99");
        driver.findElement(By.id("add-btn")).click();

        //проверка товара
        driver.get(BASE_URL + "/");

        List<String> productNames = driver.findElements(By.cssSelector("#products-list .product-card h4"))
                .stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());

        Assertions.assertThat(productNames)
                .as("Список товаров на витрине должен содержать только что добавленный \"%s\"", productName)
                .contains(productName);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
