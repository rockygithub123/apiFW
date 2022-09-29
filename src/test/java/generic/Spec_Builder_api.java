package generic;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec_Builder_api {

	public static RequestSpecification request_spec_builder
	() {
		// TODO Auto-generated method stub
		RequestSpecBuilder req_bui=new RequestSpecBuilder();
		RequestSpecification req = req_bui.setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
	return req;
	}
	public static ResponseSpecification responce_spec_Builder(int code) {
		ResponseSpecBuilder res_bui = new ResponseSpecBuilder();
		ResponseSpecification res = res_bui.expectContentType(ContentType.JSON).expectStatusCode(code).build();
		return res;
	}

}
