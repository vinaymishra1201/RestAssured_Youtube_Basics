package schemavalidations;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class JsonSchemavalidation {
	@Test
	//generate json to jsonschema
	//https://www.liquid-technologies.com/online-json-to-schema-converter
	void jsonschemavalidations() {
		given()
		
		.when()
		.get("http://localhost:3000/posts")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonformate.json"));
		
	}
	
	

}
