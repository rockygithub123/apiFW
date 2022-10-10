package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarierTokenTest {
	@Test
	public void tokenTest()
	{
		baseURI="https://api.github.com";
		given()
		  .auth()
		   .oauth2("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")
		    .when()
		    .get("/users/repos")
		    .then()
		    .assertThat()
		    .log().all();
	}

}
