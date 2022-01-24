package RestAssured;

import org.testng.annotations.Test;

public class RestAssured {

	@Test public void
	get_email_address_for_employee() {
		

	    when().
	            get("data/{id}", 2).
	    then().
	            statusCode(200).
	            body("data.id", equalTo(2),
	                 "data.id.email", equalTo("janet.weaver@reqres.in"));

	}
	
}
