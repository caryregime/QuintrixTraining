package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class RestAPITest {

	private static String URL = "https://reqres.in";

	@Test public void
	get_email_address_for_employee() {

		String expectedEmail = "janet.weaver@reqres.in";

		Response response = 
				given()
				.when()
				.get(URL + "/api/users/2")
				.then()
				.extract()
				.response();

		String actualEmail = response.path("data.email");

		Assert.assertEquals(actualEmail, expectedEmail);
	}

	@Test public void
	post_token_after_login_successful() {

		String expectedToken = "QpwL5tke4Pnpja7X4";

		String requestBody = "{\n" 
				+ "   \"email\": \"eve.holt@reqres.in\",\n" 
				+ "   \"password\": \"cityslicka\"\n" 
				+ "}";

		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.post(URL + "/api/login")
				.then()
				.extract()
				.response();

		String actualToken = response.jsonPath().getString("token");

		System.out.println(actualToken);

		Assert.assertEquals(actualToken, expectedToken);
	}


}
