package POJO;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestPOJO {

    @Test
    void createUserPOJO()
    {
        PojoClass data = new PojoClass();
        data.setName("Dilip Velani");
        data.setLocation("Kutch");
        data.setPhone("456123987");

        String courseArry[] = {"API", "Java", "SQL"};

        data.setCourses(courseArry);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Dilip Velani"))
                .body("location",equalTo("Kutch"))
                .body("phone",equalTo("456123987"))
                .body("courses[0]",equalTo("API"))
                .body("courses[1]",equalTo("Java"))
                .body("courses[2]",equalTo("SQL"))
                .header("Content-Type", "application/json")
                .log().all();
    }

}
