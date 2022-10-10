package DDT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtiliyt;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithOutMAndotoryFieldTest {
	@Test(dataProvider = "testBody")
	public void AddProjectTest(String createdBy,String projectName,String status,int teamSize)
	{
		AddProjectPojoClass pj=new AddProjectPojoClass(createdBy, projectName, status, teamSize);
		
		baseURI="http://localhost";
		port=8084;
		given()
		  .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		  .assertThat()
		   .log()
		     .all();
		
	}
	@DataProvider
	public Object[][] testBody() throws EncryptedDocumentException, IOException
	{
		Object[][] obj=new Object[2][4];
		ExcelUtiliyt elib=new ExcelUtiliyt();
		
		
		obj[0][0]=elib.excelDataTest(0, 0);
		obj[0][1]="";
		obj[0][2]=elib.excelDataTest(0, 2);
		obj[0][3]=Integer.parseInt(elib.excelDataTest(0, 3));
		obj[1][0]=elib.excelDataTest(1,0);
		obj[1][1]="";
		obj[1][2]=elib.excelDataTest(1, 2);
		obj[1][3]=Integer.parseInt(elib.excelDataTest(1, 3));
		return obj;
		
	}

}
