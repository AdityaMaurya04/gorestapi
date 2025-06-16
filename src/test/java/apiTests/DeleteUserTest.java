package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {

    @Test(dependsOnMethods = "apiTests.CreateUserTest.createNewUser")
    public void deleteUser() {
        int delete = CreateUserTest.userId;

        Response response = getRequestSpec()
                .delete("/users/" + delete);

        Assert.assertEquals(response.getStatusCode(), 204);
        System.out.println("User deleted successfully with ID: " + delete);
    }
}