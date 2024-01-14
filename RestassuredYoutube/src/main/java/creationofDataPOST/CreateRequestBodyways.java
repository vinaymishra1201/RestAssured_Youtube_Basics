package creationofDataPOST;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;





import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.util.HashMap;

public class CreateRequestBodyways {
	int id;
	//@Test (priority = 1)
	void testpostusinghashmap() {
		
		HashMap data=new HashMap();
		data.put("name", "John Doe");
		data.put("grade","A");
		data.put("age", "20");
		String coursearr[]= {"Physics","Mathematics"};
		data.put("courses", coursearr);
		
		 id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/posts")
		.then()
		.statusCode(201)
		.body("name",equalTo ("John Doe"))
		.body("grade",equalTo("A"))
		.body("age",equalTo("20"))
         .body("courses[0]", equalTo("Physics"))
         .body("courses[1]", equalTo("Mathematics")).extract()
         .path("id");
		System.out.println("id="+id);
//         .header("Content-Type", "application/json;charset=utf-8")
//         .log().all();
		
	
	}
	// use org.json files in dependencies
	//@Test(priority = 1)
 void testpostusingjsonlibrary() {
		 
		JSONObject data=new JSONObject();
		data.put("name", "John Doe");
		data.put("grade","A");
		data.put("age", "20");
		String coursearr[]= {"Physics","Mathematics"};
		data.put("courses", coursearr);
		
		 id=given()
		.contentType("application/json")
		.body(data.toString())  //data should be in string formate
		.when()
		.post("http://localhost:3000/posts")
		.then()
		.statusCode(201)
		.body("name",equalTo ("John Doe"))
		.body("grade",equalTo("A"))
		.body("age",equalTo("20"))
         .body("courses[0]", equalTo("Physics"))
         .body("courses[1]", equalTo("Mathematics")).extract()
         .path("id");
		System.out.println("id="+id);
//         .header("Content-Type", "application/json;charset=utf-8")
//         .log().all();
		
	
	}
	//creating request body using pojo class
	//@Test(priority = 1)
     void testpostusingpojo() {
		
		Pojo_Request data=new Pojo_Request();
		data.setName("John Doe"); 
		data.setAge("20");
		data.setGrade("A");
		String coursearr[]= {"Physics","Mathematics"};
		data.setCourses(coursearr);
		id=given()
		.contentType("application/json")
		.body(data)  //dosen't need to convert the data tostring();
		.when()
		.post("http://localhost:3000/posts")
		.then()
		.statusCode(201)
		.body("name",equalTo ("John Doe"))
		.body("grade",equalTo("A"))
		.body("age",equalTo("20"))
         .body("courses[0]", equalTo("Physics"))
         .body("courses[1]", equalTo("Mathematics")).extract()
         .path("id");
		System.out.println("id="+id);

	
	}
     //using external json files;
     @Test(priority = 1)
     void testpostusingexternaljsonfile() throws FileNotFoundException {
 		
 		File f=new File(".\\body.json");
 		FileReader fr=new FileReader(f);
 		JSONTokener jt =new JSONTokener(fr);
 		JSONObject data=new JSONObject(jt); 
 		id=given()
 		.contentType("application/json")
 		.body(data.toString())  // convert the data tostring();
 		.when()
 		.post("http://localhost:3000/posts")
 		.then()
 		.statusCode(201)
 		.body("name",equalTo ("John Doe"))
 		.body("grade",equalTo("A"))
 		.body("age",equalTo("20"))
          .body("courses[0]", equalTo("Physics"))
          .body("courses[1]", equalTo("Mathematics")).extract()
          .path("id");
 		System.out.println("id="+id);

 	
 	}
	
	
	//deleting the record
	//@Test(priority = 2)
	void deletetest() {
		given()
		
		.when()
		.delete("http://localhost:3000/posts/"+id)
		.then().statusCode(200);
		
	}
}
