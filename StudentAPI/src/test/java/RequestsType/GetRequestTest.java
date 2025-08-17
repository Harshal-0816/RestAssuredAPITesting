package RequestsType;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetRequestTest {

    @Test
    void getUser()
    {
        given()

        .when()
                .get("http://localhost:3000/students")

        .then()
                .statusCode(200);
    }



}
