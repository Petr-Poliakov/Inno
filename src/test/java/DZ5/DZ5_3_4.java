package DZ5;

import com.codeborne.selenide.Configuration;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.endpoints.GoodApi;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DZ5_3_4 {

    private final GoodApi api = new GoodApi();
    private long createdProductId;

    @BeforeEach
    void setup() {
        Configuration.baseUrl = "http://localhost:8080";
    }

    @Test
    void editProductCheckChanges() {
        String originalName = "БудетИзменён";
        String updatedName = "Изменённый";


        Response createResponse = api.createGoods(originalName, 40.0);
        createdProductId = createResponse.jsonPath().getLong("data.id");

        // логинимся и редактируем товар в админке
        open("/login");
        $("#username").setValue("admin");
        $("#password").setValue("secret123");
        $("button[type='submit']").click();

        open("/admin");
        $("#nm-" + createdProductId).shouldBe(visible).clear();
        $("#nm-" + createdProductId).setValue(updatedName);
        $("#pr-" + createdProductId).clear();
        $("#pr-" + createdProductId).setValue("77");
        $("button[data-action='update'][data-id='" + createdProductId + "']").click();

        $("#toast-container .toast")
                .shouldBe(visible)
                .shouldHave(text("Товар #" + createdProductId + " обновлен"));

        //переход к товарам
        open("/");
        $(".product-card[data-name='" + updatedName + "'] h4").shouldHave(text(updatedName));
        $(".product-card[data-name='" + updatedName + "'] h4 + div").shouldHave(text("77"));
    }

    @AfterEach
    void tearDown() {
        // п.3.6: тестовые данные удаляются через API
        if (createdProductId != 0) {
            api.deleteGoodById(createdProductId);
        }
        closeWebDriver();
    }
}
