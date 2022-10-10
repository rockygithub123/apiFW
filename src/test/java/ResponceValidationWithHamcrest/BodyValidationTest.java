package ResponceValidationWithHamcrest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class BodyValidationTest {
	@Test
	public void bodyTest()
	{
		baseURI="http://localhost";
		port=8084;
		 when().get("projects")
	 .then().assertThat().body("[0].projectId", "a");
//		
//		 String body = res.getBody().asString();
//		 System.out.println(body);
//		// System.out.println(res.body().toString());
//		
//		 
//		 String exp="TY_PROJ_008";
//		 boolean flag=false;
//		if(body.contains(exp))
//		{System.out.println("body is present");
//		flag=true;
//		}
//		Assert.assertTrue(flag);
	}

}
