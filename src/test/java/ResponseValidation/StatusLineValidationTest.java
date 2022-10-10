package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StatusLineValidationTest {
	@Test
	public void statusLine()
	{
		baseURI="http://localhost/";
		port=8084;
	Response resp = when().get("projects");
	 String ExpectedStatusLine="HTTP/1.1 200 ";
	 String actualStatusLine = resp.getStatusLine();
	 
	 Assert.assertEquals(ExpectedStatusLine, actualStatusLine);
	}  

}
