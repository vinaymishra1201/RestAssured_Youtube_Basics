package authentication;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	/*  
	 * json object{
	 * }
	 * json array[
	 * ]
	 * jsone element // it can be json object or json array*/
	@Test
	void testGenerateDummyData() {
		Faker faker=new Faker();
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String Lastname=faker.name().lastName();
		
		String username=faker.name().username();
		String password=faker.internet().password();
		System.out.println("Fullname"+fullname);
		
		
		String phonen=faker.phoneNumber().cellPhone();
		String emailadd=faker.internet().safeEmailAddress();
		System.out.println(emailadd);
	}

}
