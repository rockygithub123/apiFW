package GenericUtility;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * this is used to get json data 
 * @author GOWTHAM
 *
 */


public class RestLibrary {
	public void preConditions()
	{
		baseURI="http://localhost";
		port=8084;
	 given().contentType(ContentType.JSON);
	}
	public String getJsonData(Response responce,String path)
	{
		String jsonData = responce.jsonPath().get(path);
		return jsonData;
		}

}
