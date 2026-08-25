package rest.assertions;

import io.restassured.response.Response;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

//базовый конструктор
public class BasicApiAssert extends AbstractAssert <BasicApiAssert, Response> {
    protected BasicApiAssert(Response actual) {
        super(actual, BasicApiAssert.class);
        actual.prettyPrint(); //- вывод в консоль
    }

    public static BasicApiAssert assertThat(Response actual){
        return new BasicApiAssert(actual);
    }


    public BasicApiAssert statusCodeIsEqual(int code) {
        Assertions.assertThat(actual.statusCode())
                .as("Status code must be %d".formatted(code))
                .isEqualTo(code);

        return this;
    }

    public BasicApiAssert fieldIsExists(String path){
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Fields with path %s must be exists!".formatted(path))
                .isNotNull();

        return this;
        }

    public BasicApiAssert fieldIsEquals(String path, String value){
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Fields with path %s must be equals %s!".formatted(path, value))
                .isEqualToIgnoringCase(value);

        return this;
    }

    public BasicApiAssert headerIsEqual (String header, String value){
        Assertions.assertThat(actual.getHeader(header))
                .as("Header '%s' must be equal '%s'".formatted(header, value))
                .isEqualToIgnoringCase(value);

        return this;
        }

    public BasicApiAssert listSizeEqualOrGreater(String path, int size) {
        Assertions.assertThat(actual.jsonPath().getList(path, String.class))
                .as("List with path %s must be size %d or greater".formatted(path, size))
                .hasSizeGreaterThanOrEqualTo(size);

        return this;
    }

}





