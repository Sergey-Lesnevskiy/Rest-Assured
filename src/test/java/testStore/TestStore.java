package testStore;

import body.BodyStore;
import endPoints.EndPointStore;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utilAPI.BodyStoreSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestStore {
    protected static RequestSpecification requestSpec = BodyStoreSpecification.getRequestSpecification();

    private static File jsonSchema = new File("src/test/resources/store.json");

    @Test
    public void testGet() {
        ValidatableResponse response = given()
                .spec(requestSpec)
                .when()
                .get(EndPointStore.STATUS)
                .then()
                .statusCode(200);

//        String responseBody =  response.
//        JsonParser parser = new JsonParser();
//        Integer sold = parser.parse(responseBody)
//                .getAsJsonObject().get("sold").getAsInt();// почему приходят разные данные?
//      //  Assertions.assertEquals(expectedSold, sold);
    }

    @Test
    public void testPost() {
        BodyStore bodyStore = new BodyStore(12344321, 1, 1, "2021-08-24T15:14:38.874Z", "placed", true);
        given().spec(requestSpec)
                .when()
                .body(bodyStore)
                .post(EndPointStore.BODY)
                .then()
                .statusCode(200)
                .assertThat();

    }

    @Test
    public void testDelete() {
        ValidatableResponse response = given()
                .spec(requestSpec)
                .when()
                .delete(EndPointStore.DELETE)
                .then()
                .statusCode(404);

    }
}
