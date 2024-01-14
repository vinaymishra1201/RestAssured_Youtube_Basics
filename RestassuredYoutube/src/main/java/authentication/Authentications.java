package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {
	//@Test(priority = 1)
	void testbasicauthentications() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	//@Test
	void testDigestauthentications() {
		//internally it will be different in basic auth it will directly 
	//hit the server and type name and pwd but in digest first it will 
//verify then will type username and pwd
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	//@Test
	void testPreemptiveAuthentications() {
	    given()
	    //premitive=basic+digest;
	    //all three are different 
	    .auth().preemptive().basic("postman", "password")
	    .when()
	    .get("https://postman-echo.com/basic-auth")
	    .then()
	    .statusCode(200)
	    .body("authenticated", equalTo(true))
	    .log().all();
	}
	//@Test
	void barrerToken() {
		String barrertoken="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";
		given()
		.header("Authorization","Bearer "+barrertoken)//make space;
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200).log().all();
	}
	//@Test
	void testauth1() {
		given()
		.auth().oauth("consumerKey", "consumerSecrate", "accessToken", "tokenSecrate")
		.when()
		.get("url of web")
		.then().statusCode(201).log().all();
	}
	//@Test
	void testauth2Authentication() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then().statusCode(200).log().all();
	}
	@Test
	void testAPIAuthentication() {
		//Methord 1
		/*given()
		.queryParam("Authweather", "2c236c041e0046d8891fcc934ec95acf")//app id=acuweater
		.when()
		.get("https://openweathermap.org/faq?Authweather=2c236c041e0046d8891fcc934ec95acf#error401")
		
		.then().statusCode(200).log().all();*/
		//Methord 2
		given()
		.queryParam("Authweather", "2c236c041e0046d8891fcc934ec95acf")//app id=acuweater
		.pathParam("mypath", "faq")//like this make new query params after?
		//.queryParam("", null)
		.when()
		.get("https://openweathermap.org")
		
		
		.then().statusCode(200).log().all();
		
	}
	

}
