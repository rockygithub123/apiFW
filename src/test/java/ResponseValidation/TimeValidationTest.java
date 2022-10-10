
package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

public class TimeValidationTest {
	public void timeValidationTest()
	
	{ port=8084;
		when()
		   .get("/projects")
		  .then()
		    .assertThat()
		      .time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS);
		
	}

}
