package ResponceValidationWithHamcrest;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class StaticValidation {
	@Test
public void validation()
{
	baseURI="http://localhost";
	port=8084;
	Response response = when().get("/projects");
	
	String expected="TY_PROJ_008";
	String actual = response.jsonPath().get("[2].projectId");
	Assert.assertEquals(expected, actual);
	

	}
}
