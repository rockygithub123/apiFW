package CurdWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectest {
	@Test
	public void createProject()
	{  //create a json object
		JSONObject js=new JSONObject();
		int ran = new Random().nextInt(500);
		//create body using json simple
		js.put("createdBy","rocky00");
		js.put("projectName", "p2019"+ran);
		js.put("status","active");
		js.put("teamSize",10);
		//pre-condition (body and content type)
		RequestSpecification reqspe = RestAssured.given();
		reqspe.body(js);
		reqspe.contentType(ContentType.JSON);
		//perform action
		Response res = reqspe.post("http://localhost:8084/addProject");
		//read the data
		ValidatableResponse validate = res.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		
		
	}

}
