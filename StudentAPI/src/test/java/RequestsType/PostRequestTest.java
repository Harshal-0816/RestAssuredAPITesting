package RequestsType;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class PostRequestTest {

    public String id;

    @Test(priority = 1)
    void createUser()
    {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name","Harshal Velani");
        data.put("location", "Nashik");
        data.put("phone","1245789630");

        String[] courseArr = {"BDD", "TDD", "Cucumber"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data)

            .when()
                .post("http://localhost:3000/students")
                .jsonPath().getString("id");

            /*
            .then()
                .statusCode(201)
                .body("name",equalTo("Harshal Velani"))
                .body("location",equalTo("Nashik"))
                .body("phone",equalTo("1245789630"))
                .body("courses[0]",equalTo("BDD"))
                .body("courses[1]",equalTo("TDD"))
                .body("courses[2]",equalTo("Cucumber"))
                .header("Content-Type", "application/json");
             */
    }

}
