package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest extends BaseTest {

    public static int userId;

    @Test
    public void createNewUser() {
        Map<String, String> body = new HashMap<>();
        body.put("name", "aditya");
        body.put("email", "aditya@test.com");
        body.put("gender", "male");
        body.put("status", "active");

        Response response = getRequestSpec()
                .body(body)
                .post("/users");

        Assert.assertEquals(response.getStatusCode(), 201);

        String name = response.jsonPath().getString("name");
        String email = response.jsonPath().getString("email");
        String gender = response.jsonPath().getString("gender");
        String status = response.jsonPath().getString("status");

        Assert.assertEquals(name, body.get("name"));
        Assert.assertEquals(email, body.get("email"));
        Assert.assertEquals(gender, body.get("gender"));
        Assert.assertEquals(status, body.get("status"));

        userId = response.jsonPath().getInt("id");

        System.out.println("User ID: " + userId);
        System.out.println("User Details: "+response.asString());
    }
}