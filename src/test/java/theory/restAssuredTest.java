package theory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class restAssuredTest {
    public record Request1 (String args1, Integer args2){}
    public record Good (String name, Double price){}

    //- пример переменной спецификации для вызовов на общие методы
    public RequestSpecification basicRQ = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .log(LogDetail.ALL)
            .addQueryParam("page",0)
            .build();
    @Test
    void raTest(){
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .queryParam("page", 0)
                .queryParam("size", 1000)
                //.contentType(ContentType.JSON)
                //.body("""
                /*        {
                        "key1": "value1",
                        "key2": "value2",
                        "key3": "value3",
                        }
                        """); */
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
        ;

    }

    @Test
    void rqTest(){
        given()
                .spec(basicRQ)
                .queryParam("size", 1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .contentType("applicatiom/json; charset=utf-8"); //полезная проверка
    }
}
