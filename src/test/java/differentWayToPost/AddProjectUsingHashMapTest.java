package differentWayToPost;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectUsingHashMapTest {
	@Test
	public void addProjectTest()
	{
		int ran=new Random().nextInt(500);
		HashMap body = new HashMap();
		body.put("createdBy", "rock");
		body.put("projectName", "l50"+ran);
		body.put("status", "active");
		body.put("teanSize",50);
		baseURI="http://localhost";
		port=8084;
		
		given()
		 .body(body)
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
