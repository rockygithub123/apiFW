package RequestChaining;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class getAndupdate {
	@Test
public void deleteTest()
{
	baseURI="http://localhost";
	port=8084;
	Response resp = when()
	.get("projects");
	String pid = resp.jsonPath().get("[3].projectId");
	
	JavaUtility jv=new JavaUtility();
	int ran = jv.randomNumber();
	
	AddProjectPojoClass pj=new AddProjectPojoClass("kk", "suryayana12"+ran, "active", 30);
	given()
	  .body(pj)
	  .contentType(ContentType.JSON)
	  .pathParam("pid", pid)
	 .when()
	   .put("projects/{pid}")
	   .then().log().all();
	
	
	
	
	
	
	
	}
}
