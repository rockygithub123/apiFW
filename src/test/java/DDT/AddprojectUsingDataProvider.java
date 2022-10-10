package DDT;

import java.io.IOException;

import javax.swing.text.AbstractDocument.Content;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ReadDataFromExcelTest;
import PojoClassGenericUtility.AddProjectPojoClass;
import differentWayToPost.AddProjectUsingPojoClassTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddprojectUsingDataProvider {
	@Test(dataProvider = "TestBody1")
	public void addProjectTest(String createdBy,String projectName,String status,int teamSize)
	{
		AddProjectPojoClass pj = new AddProjectPojoClass(createdBy, projectName, status, teamSize);
		baseURI="http://localhost";
		port=8084;
		given()
		  .contentType(ContentType.JSON)
		  .body(pj)
		.then()
		  .when()
		   .post("/addProject")
		 .then()
		   .assertThat()
		   .contentType(ContentType.JSON)
		   .log().all();
	}
	@DataProvider
	public Object[][] TestBody1() throws EncryptedDocumentException, IOException
	{
		GenericUtility.DataProvider dt=new GenericUtility.DataProvider();
		Object[][] obj1 = dt.TestBody(4,4);

	
		return obj1;
	}

}

