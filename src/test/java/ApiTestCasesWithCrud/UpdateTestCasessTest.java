package ApiTestCasesWithCrud;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateTestCasessTest {
int	ran=new Random().nextInt(500);
	
	@Test(groups = {"smoke"})
	public void updateProjectTest()
	{
		  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .put("projects/TY_PROJ_008")
		.then()
		     .assertThat()
		       .log().all();
	
	}
	@Test
	public void updateProjectWithOutBodyTest()
	{
		  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		given()
		    //.body()
		    .contentType(ContentType.JSON)
		.when()
		    .put("projects/TY_PROJ_008")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test
	public void updateProjectWithPartialBodyTest()
	{
		  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		//js.put("projectName", "pr01"+ran);
		//js.put("status", "active");
		//js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .put("projects/TY_PROJ_008")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test
	public void updateProjectWithPostMethodTest()
	{
		  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("projects/TY_PROJ_008")
		.then()
		     .assertThat()
		       .log().all();
	}

	@Test
	public void updateProjectWithOtherProtocalTest()
	{
		  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="https://localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .put("projects/TY_PROJ_008")
		.then()
		     .assertThat()
		       .log().all();
	
	}
	

}
