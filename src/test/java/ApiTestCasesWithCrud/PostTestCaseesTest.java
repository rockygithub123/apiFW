package ApiTestCasesWithCrud;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class PostTestCaseesTest {
	int ran= new JavaUtility().randomNumber();
	@Test(groups = {"smoke"},invocationCount = 1)
	public void addProjectTest()
	{
		int ran= new Random().nextInt(500);  
		JSONObject js=new JSONObject();
		js.put("createdBy", "king");
		js.put("projectName", "pr01"+ran);
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		
		Response res = given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject");
		String  actual = res.getStatusLine();
		String expected="HTTP/1.1 201 ";
		String actvary=res.getHeader("vary");
		String expecvary="Access-Control-Request-Headers";
		String expPragma="no-cache";
		String actualtPragma=res.getHeader("pragma");
		Assert.assertEquals(expected,actual);
		Assert.assertEquals(expecvary, actvary);
		Assert.assertEquals(expPragma, actualtPragma);
		 
	
		
	}
	@Test
	public void addProjectWithOutBodyTest()
	{
		int ran = new Random().nextInt(500);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given()
		    //.body()
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject");
		String expSL="HTTP/1.1 500 ";
		String actSL=resp.getStatusLine();
		Assert.assertEquals(expSL, actSL);
		
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
		
		Response resp = given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject");
		String expeSL="HTTP/1.1 201 ";
		String actSL=resp.getStatusLine();
		Assert.assertEquals(expeSL, actSL);
		String expbd="null";
		String actbd=resp.getBody().toString();
		boolean flag=false;
		if(actbd.contains(actbd))
		{
			flag=true;
			System.out.println("null present");
		}
		Assert.assertTrue(flag);
		
		
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
		
		Response resp = given()
		    .body(js)
		    .contentType(ContentType.JSON)
		.when()
		    .post("/addProject");
		String expSL="HTTP/1.1 409 ";
		String actSL=resp.getStatusLine();
		Assert.assertEquals(expSL, actSL);
		
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
//port=8084;
		
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
