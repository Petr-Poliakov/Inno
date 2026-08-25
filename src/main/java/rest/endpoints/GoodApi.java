package rest.endpoints;

import io.restassured.response.Response;
import rest.RestApiBuilder;

import static rest.RestApiBuilder.getBuilder;
import static rest.endpoints.Urls.ADD;

public class GoodApi {
    public record DTOGood(String name, Double price){}

    public Response createGoods(String name, double price){
        return getBuilder().getContentType().getSpec()
                .body(new DTOGood(name,price))
                .post(ADD);
    }

    public Response getGoodById(long id){
        return getBuilder().getSpec()
                .get("/" + id);
    }

    public Response deleteGoodById(long id){
        return getBuilder().getSpec()
                .delete("/" + id);
    }

    public Response patchGood(long id, String name, double price){
        return getBuilder().getContentType().getSpec()
                .body(new DTOGood(name, price))
                .patch("/" + id);
    }


}
