package api_scripts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import generic.Spec_Builder_api;

public class Rest1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub



Response b = given().spec(Spec_Builder_api.request_spec_builder()).when(). 
get("/api/users/2").then().spec(Spec_Builder_api.responce_spec_Builder(200)).extract().response(); 
//System.out.println(b.asString());
System.out.println(b.asPrettyString());

	}

}
