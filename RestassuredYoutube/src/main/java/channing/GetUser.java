package channing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	@Test
	void test_getuser(ITestContext context) {
		int id=(int) context.getAttribute("user_id");
		String bearerToken="b6194171c435b64bc25260fb9b4dd86b02434d9a9fa8943519982f0e13800041";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}
}
