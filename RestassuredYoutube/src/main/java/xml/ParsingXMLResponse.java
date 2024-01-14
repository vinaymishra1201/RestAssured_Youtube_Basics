package xml;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class ParsingXMLResponse {
	//@Test
	void testXMLResponse() {
		//http://restapi.adequateshop.com/swagger/ui/index
		//http://restapi.adequateshop.com/api/Traveler?page=1
		//aproach 1
		/*given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")//index will start with zero
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
		*/
		
		//Approach 2
		Response se=given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(se.getStatusCode(), 200);
		Assert.assertEquals(se.header("Content-Type"), "application/xml; charset=utf-8");
		String pageno=se.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno, "1");
		String Travelname=se.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(Travelname, "Developer");
		
		
	}
	@Test
	void testXMLResponseBody() {
		//tostring() will convert only body 
		//asString() will convert wole response "se"
		Response se=given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
				XmlPath xmlobj=new XmlPath(se.asString());//getlist will get all the notes
				//total no of travellers 
				List<String>travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
				Assert.assertEquals(travellers.size(), 10);
				//verfiy travellername is present in the response or not
				List<String>travellersnames=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
				boolean status=true;
				for(String travel_name:travellersnames) {
					//System.out.println(travel_name);
					if(travel_name.equals("1234")) {
						if(status=true) {
							break;
						}
					}
					Assert.assertEquals(status, true);
				}
		
	}
	
}
