package CurdWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetProjectTest {
	@Test
	public void getTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		  .get("/projects/TY_PROJ_006")
	.then()
	
	    .assertThat()
	         .contentType(ContentType.JSON)
		     .statusCode(200)
		     .log().all();
		
	}

}
