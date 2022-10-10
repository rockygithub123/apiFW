package Authentication;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicauthenticationTest {
	@Test
	public void basicauthTest()
	{
	baseURI="http://localhost";
    port=8084;
    given()
     .auth().basic("rmgyantra","rmgy@9999")
    .when()
      .get("/login")
      .then().assertThat().statusCode(202)
      .log().all();
 
	}

}
