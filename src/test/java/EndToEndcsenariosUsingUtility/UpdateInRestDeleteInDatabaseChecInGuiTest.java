package EndToEndcsenariosUsingUtility;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class UpdateInRestDeleteInDatabaseChecInGuiTest extends BaseClass {
	@Test
	public void validationTest()
	{
		//update in rest
		String pID="TY_PROJ_2019";
		RequestSpecification req = sLib.request_spec_builder();
		String pName="prj2022";
		AddProjectPojoClass pj=new AddProjectPojoClass("rock", pName, "active", 10);
		req
		  .body(pj)
		.when().put(EndPointsLibrary.updateProject+pID)
		.
		
		
	}

}
