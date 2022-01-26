package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class RestAPITest {

	@Test public void
	get_email_address_for_employee() {
		String URL = "https://reqres.in/api/users/2";
		String email = "janet.weaver@reqres.in";
		int expectedStatusCode = 200;
		int dataId = 2;
		
		given()
			.get(URL)
			.then()
			.statusCode(expectedStatusCode)
			.body("data.id[dataId].email", equalTo("janet.weaver@reqres.in"));

	}

}
