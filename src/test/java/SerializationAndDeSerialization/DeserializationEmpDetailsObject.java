package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpDetailsWithArray;
import Pojo.EmpDetailsWithObject;

public class DeserializationEmpDetailsObject {
	@Test
	void empDetails() throws JsonParseException, JsonMappingException, IOException
	{
		//create a object for mapper
		ObjectMapper obj= new ObjectMapper();
		//read the value from json object
		  EmpDetailsWithObject val = obj.readValue(new File("./EmpDetailswithObjcet.json"), EmpDetailsWithObject.class);
		System.out.println(val.getEmName());
		System.out.println(val.getEmpid());
		System.out.println(val.getEmpAdd());
		System.out.println(val.getPhNo());
	}

}
