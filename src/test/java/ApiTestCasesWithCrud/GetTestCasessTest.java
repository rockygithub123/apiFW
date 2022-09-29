package ApiTestCasesWithCrud;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetTestCasessTest {
	@Test(groups = {"smoke"})
	public void getProjectsTest()
	{
		baseURI="http://localhost";
		port=8084;
		when()
		   .get("/projects").
		then()
		   .assertThat()
		     .log().all();
		   
		   
		
	}
	@Test
	public void getProjectWithOuutUriTest()
	
	{
		when()
		   .get("/projects")
		.then()
		   .assertThat()
		     .log().all();
	}
	@Test
	public void getProjectWithOuutPOrtNumTest()
	
	{
		baseURI="http://localhost";
		when()
		   .get("/projects")
		.then()
		   .assertThat()
		     .log().all();
	}
	@Test
	public void getProjectWithWrongURITest()
	
	{
		baseURI="http://localhos";
		port=8084;
		when()
		   .get("/projects")
		.then()
		   .assertThat()
		     .log().all();
	}
	@Test
	public void getProjectWithWrongportNumTest()
	
	{
		baseURI="http://localhost";
		port=8086;
		when()
		   .get("/projects")
		.then()
		   .assertThat()
		     .log().all();
	}
	@Test
	public void getProjectsWithOutEndPointTest()
	{
		baseURI="http://localhost";
		port=8084;
		when()
		   .get("").
		then()
		   .assertThat()
		     .log().all();
		   
		   
		
	}
	@Test
	public void getProjectsWithOutEndPointAndJsonResponceTest()
	{
		baseURI="http://localhost";
		port=8084;
		when()
		   .get("").
		then()
		   .assertThat()
		   .contentType(ContentType.JSON)
		     .log().all();
		   
		   
		
	}
	@Test
	public void getProjectsWithWrongIdTest()
	{
		baseURI="http://localhost";
		port=8084;
		when()
		   .get("/TY_PROJ_10002222").
		then()
		   .assertThat()
		   //.contentType(ContentType.JSON)
		     .log().all();
		   
		   
		
	}

}
