package channing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UpdateUser {
	@Test
	void test_updateuser(ITestContext context) {
		int id=(int) context.getAttribute("user_id");
		Faker faker =new Faker();
		JSONObject data =new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		String bearerToken="b6194171c435b64bc25260fb9b4dd86b02434d9a9fa8943519982f0e13800041";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		
		.body(data.toString())
		.pathParam("id", id)
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}
}
