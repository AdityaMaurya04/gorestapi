package apiTests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    String token = "Bearer 82c34ba308105b79c63b2b934319945172cb9026bc1a3a59494d29595846e6cd";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    public RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .header("Authorization", token)
                .header("Content-Type", "application/json");
    }
}