package rest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import rest.endpoints.Urls;

import static io.restassured.RestAssured.given;

public class RestApiBuilder {
    RequestSpecification spec; // переменная
    private final static String
            BASIC_IRL = "http://localhost:8080",
            LOGIN  = "admin",
            PASSWORD ="secret123";


    public RestApiBuilder(){ //метод Иннициализатор кладет в переменную spec URL
        spec = given().baseUri(BASIC_IRL)
                .basePath(Urls.GOODS)
                .log().all()
                .relaxedHTTPSValidation();

    }

    public RestApiBuilder(String url){ //метод Иннициализатор кладет в переменную spec URL
        spec = given().baseUri(url);

    }



    public RestApiBuilder addAuth (String login, String password){
        spec = spec.auth().basic(login, password);
        return this;
    }

    public RestApiBuilder getContentType (){
        spec = spec.contentType(ContentType.JSON);
        return this;
    }



   public RequestSpecification getSpec() {
       return spec;
   }

    public static RestApiBuilder getBuilder(){
        return new RestApiBuilder().addAuth(LOGIN, PASSWORD);
    }

    public static RestApiBuilder getBuilderWithoutAuth(){
        return new RestApiBuilder();
    }
}
