package Parameter;

import org.testng.annotations.Test;

import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostAndDelete {
	@Test
	public void requestChaining()
	{
	
		AddProjectPojoClass pj=new AddProjectPojoClass("kk", "suryayana12", "active", 30);
		baseURI="http://localhost";
		port=8084;
		Response resp = given()
		.body(pj)
		.contentType(ContentType.JSON)
		.when()
		    .post("/addProject");
	String pID = resp.jsonPath().get("projectId");	
	given().pathParam("projectId",pID)
		.when()
		.delete("projects/{projectId}")
		.then().log()
		.all();
		
		
	}

}
