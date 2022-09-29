package api_scripts;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class postt {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    RestAssured.baseURI ="https://reqres.in/api/users?page=2"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("userName", "test_rest");
	    requestParams.put("password", "Testrest@123"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.put("ok"); 
	    ResponseBody body = response.getBody();
	    System.out.println(response.toString());
	    System.out.println(body.asString());
	     
		

	}

}
