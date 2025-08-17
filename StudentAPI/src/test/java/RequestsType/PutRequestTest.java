package RequestsType;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutRequestTest {

    @Test
    void updateUser()
    {
        //importing variable from PostRequestTest class
        PostRequestTest postObj = new PostRequestTest();
        postObj.createUser();
        String id = postObj.id;

        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", "Harsh");
        data.put("location", "Deshalpar");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .put("http://localhost:3000/students/"+id)

                .then()
                .statusCode(200)
                .log().all();


    }


}
