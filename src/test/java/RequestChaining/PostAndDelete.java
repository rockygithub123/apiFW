package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndDelete {
	@Test
	public void requestChaining()
	{
		JavaUtility jv=new JavaUtility();
		int ran = jv.randomNumber();
		
		AddProjectPojoClass pj=new AddProjectPojoClass("kk", "suryayana12"+ran, "active", 30);
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
