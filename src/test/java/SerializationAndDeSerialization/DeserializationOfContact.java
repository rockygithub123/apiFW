package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpDetailsWithObject;
import Pojo.MobileContact;

public class DeserializationOfContact {
	@Test
	void empDetails() throws JsonParseException, JsonMappingException, IOException
	{
		//create a object for mapper
		ObjectMapper obj= new ObjectMapper();
		//read the value from json object
		   MobileContact val = obj.readValue(new File("./contact"), MobileContact.class);
		System.out.println(val.getFn());
		System.out.println(val.getLn());
		System.out.println(val.getCompanyName());
		System.out.println(val.geteMail());
		System.out.println(val.getFamily());
	}

}
