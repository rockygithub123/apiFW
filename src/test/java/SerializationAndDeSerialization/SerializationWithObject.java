package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpDetailsWithObject;
import Pojo.Spose;

public class SerializationWithObject {
	@Test
void serilization() throws JsonGenerationException, JsonMappingException, IOException
{
	//create object for pojo class
	int[] phno= {1,2,3,4,5,6};
	Spose sp = new Spose("abc", "ab123", "77854654","mysore");
	EmpDetailsWithObject objo=new EmpDetailsWithObject("rocky", "rb123", phno, "mangalore", sp);
	
	// create object for objectmapper
	ObjectMapper obj=new ObjectMapper();
	//read value 
	obj.writeValue(new File("./EmpDetailswithObjcet.json"), objo);
}
}
