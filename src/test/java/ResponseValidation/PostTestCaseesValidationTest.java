package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostTestCaseesValidationTest {
	int ran= new Random().nextInt(500);
	@Test(groups = {"smoke"},invocationCount = 2)
	public void addProjectTest()
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
		    .post("/addProject")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test
	public void addProjectWithOutBodyTest()
	{
		int ran = new Random().nextInt(500);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		    //.body()
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test
	
	public void addProjectWithMissingValuesTest()
	{
		JSONObject js=new JSONObject();
		//js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		//js.put("teamSize", 10);
		
		
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
	@Test
	public void addProjectWithOutMandatoryFieldTest()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		//js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		//js.put("teamSize", 10);
		
		
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
	@Test
	public void addProjectWithOutPortTest()
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
		    .post("/addProject")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test
	public void addProjectWithOutURITest()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		
		
		//baseURI="http://localhost";
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
	@Test
	public void addProjectWithWrongUri()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		
		
		baseURI="://localhost";
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
	@Test
	public void addProjectWithWrongFormateOfUriTest()
	{
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		
		//uri wrong Formate
		baseURI=":http//localhost";
		port=8084;
		
		given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("")
		.then()
		     .assertThat()
		       .log().all();
	}
	@Test(groups = {"smoke"},enabled = false)
	public void addProjectContentTypeTest()
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
		    .post("/addProject")
		.then()
		     .assertThat()
		       .contentType(ContentType.JSON)
		          .log().status();
		       //.log().all();
	}
	@Test
	public void addProjectStatusCodeTest()
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
		    .post("/addProject")
		.then()
		     .assertThat()
		       .statusCode(201)
		         .log().status();
		         
		       //.log().all();
	}
	@Test
	public void addProjectStatusLineTest()
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
		    .post("/addProject")
		.then()
		     .assertThat()
		     .statusLine("HTTP/1.1 201 ")
		         .log().status();
		         
		       //.log().all();
	}
	@Test
	public void addProjectwithgetMethodTest()
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
		    .get("/addProject")
		.then()
		     .assertThat()
		       //.statusLine("HTTP/1.1 201 ")
		         .log().status();
		         
		       //.log().all();
	}
	@Test
	public void addProjectWithOutEndPOintTest()
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
		    .post("")
		.then()
		     .assertThat()
		       .log().all();
	}





}
