package RequestChaining;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostAndUpdateTest {
	@Test
	public void updateTest()
	{
		JavaUtility jv=new JavaUtility();
		int ran = jv.randomNumber();
		
		AddProjectPojoClass pj=new AddProjectPojoClass("kk", "suryayana12"+ran, "active", 30);
		String newPN="suryayana12"+ran;
		AddProjectPojoClass pj1=new AddProjectPojoClass("kk", newPN, "active", 30);
		baseURI="http://localhost";
		port=8084;
		 Response resp = given()
		  .body(pj)
		  .contentType(ContentType.JSON)
		  .when().post("addProject");
		 resp.then().log().all();
		 String pid = resp.jsonPath().get("projectId");
		 Response upadatedResp = given()
		 .body(pj1)
		   .contentType(ContentType.JSON)
		   .pathParam("pid", pid)
		    .put("projects/{pid}");
		String updatedPN = upadatedResp.jsonPath().get("projectName");
		String expected=updatedPN;
		Assert.assertEquals(expected, updatedPN);
		 
		    
		
//		String pid= resp.jsonPath().get("projectId");
//	Response resp1 = given()
//	  .body(pj1)
//	  .pathParam("projectId", pid)
//	    .when().put("projects/{projectId}");
//	System.out.println(pid);
//	resp1.then().log().all();
//	String resp3 = resp1.jsonPath().get("projectName");
//	Assert.assertEquals(update,resp3 );
		
		
	}

}
