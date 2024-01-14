package cookiesAndHeaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	//@Test(priority = 1)
	void testcookies() {
		given()
		
		.when()
		.get("https://www.google.com/")
		.then()// cookie will fail because value getting changed !so Good!
		.cookie("AEC","Ackid1QrHBjUi8maYQojGsLnl2LEY66HCII1FeEGgnM2kpH4k6K_K5ardNE")
		.log().all();
	}
	@Test(priority = 2)
	void getAllCookies() {
	    // Sending a GET request to the specified URL
	    Response response = given()
	            .when()
	            .get("https://www.google.com/"); 

	    // Retrieving all cookies from the response
	    Map<String, String> cookies = response.getCookies();

	    // Accessing and printing the value of a specific cookie (in this case, "AEC")
	    /*String cookieValue = cookies.get("AEC");
	    System.out.println("Value of cookie 'AEC' is " + cookieValue);*/
	    //System.out.println(cookies.keySet());
	    for(String k:cookies.keySet()) {
	    	String Cookievalues=response.getCookie(k);
	    	System.out.println(k+"   "+Cookievalues);
	    	
	    }
	    
	    
	}

}
