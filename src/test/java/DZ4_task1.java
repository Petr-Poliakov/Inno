import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodApi;

import java.util.List;

import static rest.RestApiBuilder.getBuilder;

public class DZ4_task1 {

    @Test
    void testGetList(){
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .queryParam("page", 0)
                .queryParam("size", 1000)
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("good.size()", equalTo(0))
                .extract().response()

        ;

    }

    public RequestSpecification dz4RQ = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .log(LogDetail.ALL)
            .addQueryParam("page",0)
            .build();
    @Test
    void testGetRequestSpecification(){
        given()
                .spec(dz4RQ)
                .auth()
                .basic("admin", "secret123")
                .queryParam("size", 1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("good.size()", equalTo(0));
    }


    @Test
    void testAddGood_ThenListContainsIt() {
        String goodName = "Ластик";

        Response createResponse = new GoodApi().createGoods(goodName, 15.5);
        createResponse.then().statusCode(200);

        getBuilder().getSpec()
                .queryParam("page", 0)
                .queryParam("size", 10)
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body("goods.name", hasItem(goodName));
    }


    @Test
    void testAddGoodThenListContainsIt() {
        String goodName = "Тетрадь";

        Response createResponse = new GoodApi().createGoods(goodName, 42.0);
        BasicApiAssert.assertThat(createResponse).statusCodeIsEqual(200);

        Response listResponse = getBuilder().getSpec()
                .queryParam("page", 0)
                .queryParam("size", 10)
                .when()
                .get("/list");
        listResponse.then().statusCode(200);

        List<String> names = listResponse.jsonPath().getList("goods.name", String.class);

        Assertions.assertThat(names)
                .as("Список товаров должен содержать только что созданный \"%s\"", goodName)
                .contains(goodName);
    }

}