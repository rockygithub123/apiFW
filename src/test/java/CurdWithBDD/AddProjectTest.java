package CurdWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest {
	@Test
	void createaprojectTest()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01");
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject")
		.then()
		     .assertThat()
		       .log().all();
	}

}
