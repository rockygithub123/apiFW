package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpDetails;

public class SerializationOfEmployeeDetails {
	@Test
	void serialization() throws  JsonMappingException, IOException {
	//create a object for pojo class
	EmpDetails emp=new EmpDetails("rocky", "rb18", 779586958,"Bangalore" );
	
	
	
	//step 2:- Create objectmapper from jackson mapper
	ObjectMapper objm=new ObjectMapper();
	 
	
	
	//Step3:- write the value to the 
	objm.writeValue(new File("./empDetailsWithArray.json"), emp);
	
	

}}
