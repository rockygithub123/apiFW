package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpDetailsWithArray;

public class SerializationEmpDetialsWithArray {
	@Test
	void serialization() throws JsonGenerationException, JsonMappingException, IOException
	{  // create object for pojo class
		int[] phno= {1,2,3,4,5};
		EmpDetailsWithArray emp=new EmpDetailsWithArray("rocky", "rb123", phno, "bangalore");
		
	
				//create object for object mapper
				ObjectMapper objm=new ObjectMapper();
		// write the value to json
				objm.writeValue(new File("./EmployeeDetailsWithArray.json"), emp);
	}

}
