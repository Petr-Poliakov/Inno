package rest.endpoints;

import io.restassured.response.Response;
import rest.RestApiBuilder;
import io.qameta.allure.Step;
import static rest.RestApiBuilder.getBuilder;
import static rest.endpoints.Urls.ADD;

public class GoodApi {
    public record DTOGood(String name, Double price){}

    @Step("POST /goods/add: создать товар \"{name}\" по цене {price}")
    public Response createGoods(String name, double price){
        return getBuilder().getContentType().getSpec()
                .body(new DTOGood(name,price))
                .post(ADD);
    }


    @Step("GET /goods/{id}: получить товар по id={id}")
    public Response getGoodById(long id){
        return getBuilder().getSpec()
                .get("/" + id);
    }

    @Step("DELETE /goods/{id}: удалить товар с id={id}")
    public Response deleteGoodById(long id){
        return getBuilder().getSpec()
                .delete("/" + id);
    }

    @Step("PATCH /goods/{id}: обновить товар id={id} -> имя \"{name}\", цена {price}")
    public Response patchGood(long id, String name, double price){
        return getBuilder().getContentType().getSpec()
                .body(new DTOGood(name, price))
                .patch("/" + id);
    }


}
