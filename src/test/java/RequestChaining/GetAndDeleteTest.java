package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetAndDeleteTest {
  @Test
	public void deleteTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when().get("projects");
		String pID = resp.jsonPath().get("[0].projectId");
		given()
		  .pathParam("projectId", pID)
		 .when()
		    .delete("projects/{projectId}")
		     .then().log()
		     .all();
	}

}
