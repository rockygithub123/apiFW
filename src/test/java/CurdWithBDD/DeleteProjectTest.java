package CurdWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectTest {
	@Test
public void	deleteTest()
	{
		baseURI="http://localhost";
		port=8084;
		when()
		  .delete("/projects/TY_PROJ_006")
		.then()
		   .assertThat()
		      .statusCode(204);
		  
	}

}
