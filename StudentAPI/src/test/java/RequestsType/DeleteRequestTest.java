package RequestsType;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteRequestTest {

    @Test
    void deleteUser()
    {
        PostRequestTest postObj = new PostRequestTest();
        postObj.createUser();
        String id = postObj.id;

        given()

                .when()
                        .delete("http://localhost:3000/students/"+id)

                .then()
                        .statusCode(200);

    }
}
