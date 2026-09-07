package DZ5;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DZ5_1_3 {
    WebDriver driver;

    private static final String BASE_URL = "http://localhost:8080";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/login");
    }

    @Test
    void loginWithInvalidCredentials() {
        driver.findElement(By.id("username")).sendKeys("no_admin");
        driver.findElement(By.id("password")).sendKeys("no_secret321");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String errorText = driver.findElement(By.cssSelector(".alert-danger")).getText();

        Assertions.assertThat(errorText)
                .as("При неверном логине/пароле должно показываться сообщение об ошибке")
                .contains("Неверные учетные данные пользователя");

        Assertions.assertThat(driver.getCurrentUrl())
                .as("URL после неудачного входа должен содержать параметр ошибки")
                .contains("error");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
