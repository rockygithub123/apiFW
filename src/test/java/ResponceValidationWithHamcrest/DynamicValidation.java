package ResponceValidationWithHamcrest;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class DynamicValidation {
	@Test
	public void dynamic()
	{
		baseURI="http://localhost/";
		port=8084;
		String expected="TY_PROJ_008";
		Response responce = when().get("projects");
		List<String> actual = responce.jsonPath().get("projectId");
		boolean flag=false;
		for (String pId: actual) {
			if(pId.equalsIgnoreCase(expected))
			{
				System.out.println("project found");
				flag=true;
			}
			
		}
		Assert.assertTrue(flag);
		
	}

}
