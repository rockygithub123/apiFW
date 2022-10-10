package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {
	@Test
	public void header()
	{
		baseURI="http://localhost/";
		port=8084;
		
		Response resp = when().get("projects");
		String expectedContent="application/json";
		String expectedVary="Access-Control-Request-Headers";
		String expectedPragma="no-cache";
		String actualContent = resp.getContentType();
		String actualVary = resp.getHeader("vary");
		String actualPragma = resp.getHeader("Pragma");
		Assert.assertEquals(actualPragma, expectedPragma);
		Assert.assertEquals(actualContent, expectedContent);
		Assert.assertEquals(actualVary, expectedVary);
		resp.then().log().all();
		
	}

}
