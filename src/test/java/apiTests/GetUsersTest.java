package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test
    public void getAllActiveUsers() {
    	Response response = RestAssured
                .given()
                .baseUri("https://gorest.co.in/public/v2")
                .header("Authorization", "Bearer 82c34ba308105b79c63b2b934319945172cb9026bc1a3a59494d29595846e6cd")
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, Object>> users = response.jsonPath().getList("");

        System.out.println("Active Users:");
        for (Map<String, Object> user : users) {
            if ("active".equalsIgnoreCase(user.get("status").toString())) {
                System.out.println("Name: " + user.get("name") +
                        ", Email: " + user.get("email") +
                        ", Status: " + user.get("status"));
            }
        }
    	
    }
}