package httprequestNormalFlow;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




import java.util.HashMap;

/*
 * given()
 * content type , set cookies,add auth, add parm, set headers
 * when()
 * get put post del
 * then()
 * Validations status code, extract response , extract headers cookies & response body
 */
public class HttpRequest { 
	String id;
	@Test(priority = 1)
	void getusers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		.body("page",equalTo(2)).log().all();
	}
	@Test(priority = 2)
	void createuser() {
		HashMap hp=new HashMap();
		hp.put("Name", "Vinay");
		hp.put("Job", "UE");
		
		id=given()
		.contentType("application/json")
		.body(hp)
		.when()
		.post("https://reqres.in/api/users")
		.then().statusCode(201).extract().path("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
//		
	}
	@Test(priority = 3,dependsOnMethods = {"createuser"})
	void updateuser() {
		HashMap hp=new HashMap();
		hp.put("Name", "Vinay");
		hp.put("Job1", "UE");
		
		given()
		.contentType("application/json")
		.body(hp)
		.when()
		.put("https://reqres.in/api/users/" + id)
		.then().statusCode(200).log().all();
		
	}
	@Test(priority = 4)
	void deleteuser() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2"+id)
		.then().statusCode(204).log().all();
	}

}
