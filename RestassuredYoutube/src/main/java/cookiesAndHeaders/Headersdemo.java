package cookiesAndHeaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Headersdemo {
	//@Test(priority = 1)
		void testHeaders() {
			given()
			
			.when()
			.get("https://www.google.com/")
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip");
			
			
		}
	@Test(priority = 2)
	void getHeaders() {
		 Response res=given()
		
		.when()
		.get("https://www.google.com/");
//		String headervalue=res.getHeader("Content-Type");
//		System.out.println("The value of Content-Type is  "+headervalue);
		 //get all headers INFO
		 //header =store single key value pair
		 //headers =store multiple key value paris
		 Headers myheader=res.getHeaders();
		 for(Header hd: myheader) {
			 System.out.println("Headers "+hd.getName()+"    "+hd.getValue());
			 
		 }
		
		
		
	}
	

}
