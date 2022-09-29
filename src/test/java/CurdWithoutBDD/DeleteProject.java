package CurdWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	void delete()
	{
		RestAssured res= new RestAssured();
		Response validate = res.delete("http://localhost:8084/projects/TY_PROJ_002");
		validate.then().log().all();
	}

}
