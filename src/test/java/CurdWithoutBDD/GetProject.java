package CurdWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	@Test
	void project()
	{
		RestAssured ra = new RestAssured();
		Response res = ra.get("http://localhost:8084/projects");
		res.prettyPeek();
	
		
		
		
		}

}
