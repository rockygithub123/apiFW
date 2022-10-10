package GenericUtility;

import io.restassured.response.Response;
/**
 * this is used to get json data 
 * @author GOWTHAM
 *
 */


public class RestLibrary {
	public String getJsonData(Response responce,String path)
	{
		String jsonData = responce.jsonPath().get(path);
		return jsonData;
		}

}
