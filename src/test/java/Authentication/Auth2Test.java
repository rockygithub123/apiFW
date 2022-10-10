package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2Test {
	@Test
	public void authTest()
	{
	Response resp = given()
		.formParam("client_id", "mytest1")
		.formParam("client_secret", "8f5389e256c7a0647682ae79709429a7")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "www.redirect.com")
		.formParam("code", 3890)
		.when()
		  .post("http://coop.apps.symfonycasts.com/token");
	System.out.println(resp);
	String token = resp.jsonPath().get("access_token");
	given()
	  .auth().oauth2(token)
	  .pathParam("user_id", 3890)
	  .when()
	    .post("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-count")
	    .then().log().all();

		resp.then().log().all();
		
		
		
		
	}

}
