import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.GoodApi;
import rest.endpoints.Urls;

import static rest.RestApiBuilder.getBuilder;

public class DZ4_task2_methods {
    private final GoodApi api = new GoodApi();

@Test
@Tag("api")
@DisplayName("[GET]/goods/{id} - 200")
void getGoodById_200() {
    Response createResponse = api.createGoods("Товар", 10.0d);
    createResponse.prettyPrint();// выводит ответ с БАГОМ api, странное поведение.
    long id = createResponse.jsonPath().getLong("data.id");

    Response response = api.getGoodById(id);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(200);
}

@Test
@Tag("api")
@DisplayName("[GET]/goods/{id} - 404")
void getGoodById_404() {
    Response response = api.getGoodById(999_999_999L);

    //возвращает баг тк код ответа 500  вместо 404
    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(404);
}


@Test
@Tag("api")
@DisplayName("[DELETE]/goods/{id} - 200")
void deleteGoodById_200() {
    Response createResponse = api.createGoods("Товар" , 10.0);
    createResponse.prettyPrint();
    long id = createResponse.jsonPath().getLong("data.id");

    Response response = api.deleteGoodById(id);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(200);
}

@Test
@Tag("api")
@DisplayName("[DELETE]/goods/{id} - 404")
void deleteGoodById_404() {
    Response response = api.deleteGoodById(999_999_999L);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(404);
}


@Test
@Tag("api")
@DisplayName("[PATCH]/goods/{id} - 200")
void patchGoodById_200() {
    Response createResponse = api.createGoods("Товар" , 10.0);
    long id = createResponse.jsonPath().getLong("data.id");

    Response response = api.patchGood(id, "Обновлённый" , 20.0);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(200);
}

@Test
@Tag("api")
@DisplayName("[PATCH]/goods/{id} - 400")
void patchGoodById_400() {
    Response createResponse = api.createGoods("Товар" , 10.0);
    long id = createResponse.jsonPath().getLong("data.id");
    
    Response response = api.patchGood(id, "Товар" , -5.0);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(400);
}

@Test
@Tag("api")
@DisplayName("[PATCH]/goods/{id} - 404")
void patchGoodById_404() {
    Response response = api.patchGood(999_999_999L, "Товар" , 10.0);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(404);
}

@Test
@Tag("api")
@DisplayName("[GET]/goods/list - 200")
void getGoodsList_200() {
    Response response = getBuilder().getSpec()
            .when()
            .get(Urls.LIST);

    BasicApiAssert.assertThat(response)
            .statusCodeIsEqual(200);
}
}
