package differentWayToPost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectUsingJsonFile {
	@Test
	public void addProjectTest()
	{
		File body = new File("./src/test/resources/testData.json");
		baseURI="http://localhost";
		port=8084;
		given()
		  .body(body)
		  .contentType(ContentType.JSON)
	   .when()
	      .post("/addProject")
	   .then()
	   .assertThat()
	   .contentType(ContentType.JSON)
	   .statusCode(201)
	   .log().all();
	   }

}
