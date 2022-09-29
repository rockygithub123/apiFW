package CurdWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test
	public void updatetest()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "k");
		js.put("projectName", "pp");
		js.put("status", "active");
		js.put("teamsize", 10);
		baseURI="http://localhost";
		port=8084;
		  given()
		      .body(js)
		      
		      .put("projects/TY_PROJ_006")
		  .then()
		      .assertThat()
		      .statusCode(201)
		      .log().all();
		
	}

}
