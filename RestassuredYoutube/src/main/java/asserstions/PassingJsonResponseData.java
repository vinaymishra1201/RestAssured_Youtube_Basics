package asserstions;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class PassingJsonResponseData {
	//@Test
	void testJoson() {
		//Aproach 1
		/*given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/posts")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("[0].author", equalTo("typicode"));
		*/
		Response res=given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/posts");
		Assert.assertEquals(res.getStatusCode(),200);// validations
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
//		String author = res.jsonPath().getString("[0].author").toString();
//		Assert.assertEquals(auther, "authername");
		
		
	}
	@Test(priority = 2)
	void testjsonBodyResponseData() {
		Response res=given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/posts");
//				Assert.assertEquals(res.getStatusCode(),200);// validations
//				Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
//				String author = res.jsonPath().getString("[0].author").toString();
//				Assert.assertEquals(auther, "authername");
	JSONObject jo=new JSONObject(res.toString());//converting resp to json tyep
//		for(int i=0;i<jo.getJSONArray("posts").length();i++) {
//			String title=jo.getJSONArray("posts").getJSONObject(i).get("author").toString();
//			System.out.println(title);
//		}//same title should be present so what to do 
	boolean status= false;
	for(int i=0;i<jo.getJSONArray("posts").length();i++) {
		String title=jo.getJSONArray("posts").getJSONObject(i).get("author").toString();
		if(title.equals("type the value")) {
			status =true;
			break;
		}
		System.out.println(title);
	}
	Assert.assertEquals(status, true);
	
			
	}
	

}
