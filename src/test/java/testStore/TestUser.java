package testStore;

import body.BodyUser;
import endPoints.EndPointStore;
import endPoints.EndPointUser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import utilAPI.BodyStoreSpecification;
import utilAPI.BodyUserSpecification;

import static io.restassured.RestAssured.given;

public class TestUser {
    protected static RequestSpecification requestSpec = BodyUserSpecification.getRequestSpecification();

    @Test
    public void testPut() {
        BodyUser bodyUser = new BodyUser(1232093, "Dimon", "Dima", "Rogov", "www.www@.ww", "1111", "104", 1);

        given().spec(requestSpec)
                .header("test", "abc123")
                .when()
                .body(bodyUser)
                .put(EndPointUser.PUT)
                .then()
                .statusCode(200)
                .assertThat();
    }
}
