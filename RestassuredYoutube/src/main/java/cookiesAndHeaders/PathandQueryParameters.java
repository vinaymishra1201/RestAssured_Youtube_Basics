package cookiesAndHeaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathandQueryParameters {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testqueryandpathparameters() {
		given()
		.pathParam("mypath", "users")//path param
		.queryParam("page", 2)//query param
		.queryParam("id", 5)//query param
		.when()
		.get("https://reqres.in/api/{mypath}")//use only path del the query
			
		.then()
		.statusCode(200).log().all();
		
	}

}
