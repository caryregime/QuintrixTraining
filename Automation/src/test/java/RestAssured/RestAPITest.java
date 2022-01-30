package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

		Response response = 
			given()
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

	@Test public void
	delete_response_204() {
		int expectedResponse = 204;

		Response response = 
			given()
			.when()
				.delete(URL + "/api/users/2")
			.then()
				.extract()
				.response();

		int actualResponse = response.getStatusCode();

		Assert.assertEquals(actualResponse, expectedResponse);
		
		/*
		 * The HTTP 204 No Content success status response code indicates that a request
		 * has succeeded, but that the client doesn't need to navigate away from its
		 * current page. This might be used, for example, when implementing
		 * "save and continue editing" functionality for a wiki site.
		 */
	}
	
	@Test public void
	patch_request() {
		
		String expectedName = "Morpheus2";
		
		String requestBody = "{\n" 
				+ "   \"name\": \"Morpheus2\",\n" 
				+ "   \"job\": \"zion resident\"\n" 
				+ "}";
		
		Response response = 
				given()
					.header("Content-type", "application/json")
					.and()
					.body(requestBody)
				.when()
					.patch(URL + "/api/users/2")
				.then()
					.extract()
					.response();

			String actualName = response.jsonPath().getString("name");
			String timestamp = response.getHeader("Date");
			timestamp = timestamp.substring(0, timestamp.length() - 7);
			System.out.println(actualName);
			System.out.println(timestamp);
			Assert.assertEquals(actualName, expectedName);
			Assert.assertEquals(timestamp, getFormattedCurrentTimeStamp());
	}
	
	@Test public void
	put_request() {
		
		String expectedName = "Morpheus2";
		
		String requestBody = "{\n" 
				+ "   \"name\": \"Morpheus2\"\n" 
				+ "}";
		
		Response response = 
				given()
					.header("Content-type", "application/json")
					.and()
					.body(requestBody)
				.when()
					.patch(URL + "/api/users/2")
				.then()
					.extract()
					.response();

			String actualName = response.jsonPath().getString("name");
			String timestamp = response.getHeader("Date");
			timestamp = timestamp.substring(0, timestamp.length() - 7);
			System.out.println(actualName);
			System.out.println(timestamp);
			Assert.assertEquals(actualName, expectedName);
			Assert.assertEquals(timestamp, getFormattedCurrentTimeStamp());
	}
	
	private String getFormattedCurrentTimeStamp() {
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(currentTime);
	}

}
