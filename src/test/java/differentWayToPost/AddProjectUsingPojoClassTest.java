package differentWayToPost;

import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AddProjectUsingPojoClassTest {
	@Test
	public void addProjectTest()
	{
		AddProjectPojoClass body = new AddProjectPojoClass("rockk", "pj01", "active", 10);
       baseURI="http://localhost";
       port=8084;
        given()
          .body(body)
          .contentType(ContentType.JSON)
        .when()
          .post("/addProject")
        .then()
         .assertThat()
         .statusCode(201)
         .contentType(ContentType.JSON)
         .log()
         .all();
         
          
          
	}

}
