package channing;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class CreateUSer {
	@Test
	void test_Createuser(ITestContext context) {
		Faker faker =new Faker();
		JSONObject data =new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		String bearerToken="b6194171c435b64bc25260fb9b4dd86b02434d9a9fa8943519982f0e13800041";
		Response res=given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://gorest.co.in/public/v2/users");
		int userid=res.then().extract().path("id");
		System.out.println(userid);
		context.setAttribute("user_id", userid);
		System.out.println(userid+"it is my id");
		
		//int userId = res.jsonPath().getInt("data.id");//u can make id from this
		

	}
}
