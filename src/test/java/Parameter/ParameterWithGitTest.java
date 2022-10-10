package Parameter;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParameterWithGitTest {
	@Test
	public void qeryParameterTest()
	{
		baseURI="https://api.github.com/";
		
	given()
	   .pathParam("username", "rockygithub123")
	  .queryParam("sort","updated")
	.when()
	   .get("users/{username}/repos")
	   .then().log().all();
	
	}

}
