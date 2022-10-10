package differentWayToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddProjectUsingJsonObjectTest {
	@Test
	public void addProjectTest()
	{int ran=new Random().nextInt(500);
		JSONObject js=new JSONObject();
		js.put("createdBy", "rock");
		js.put("projectName", "rock50"+ran);
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
		   .statusCode(201)
		   .contentType(ContentType.JSON)
		   .log().all();
	}

}
