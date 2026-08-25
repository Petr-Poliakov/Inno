package theory;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodApi;
import rest.endpoints.Urls;

import static rest.RestApiBuilder.getBuilder;

@DisplayName("[POST]/goods/add")
public class CreateGoodTest {
    String goodName = "Карандаш";
    float price = 3.3f;

    @Test
    @DisplayName("200")
    void addNewGood(){
        Response response = getBuilder().getContentType().getSpec().body("""
                {
                  "name": "%s",
                  "price": 3.3
                }
                """.formatted(goodName))
                .post(Urls.ADD);

        BasicApiAssert.assertThat(response)
                .statusCodeIsEqual(200)
                .fieldIsExists("data.id")
                .fieldIsExists("message")
                .fieldIsEquals("message","success");

    }

    @Test
    @DisplayName("400")
    void addNewGoodWithNegativePrice(){
        Response response = new GoodApi().createGoods(goodName, -2.0d);
        
        BasicApiAssert.assertThat(response)
                .statusCodeIsEqual(400);
    }

}
