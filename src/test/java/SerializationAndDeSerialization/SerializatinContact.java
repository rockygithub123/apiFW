package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Family;
import Pojo.MobileContact;

public class SerializatinContact {
	@Test
	void sc() throws JsonGenerationException, JsonMappingException, IOException {
	// create object for pojo
	Family fl=new Family("abc","4564546","bangalore");
	long[] number= {545454554,45444454,45454844,454844984};
	String [] related= {"gdshgsdhg","vcgsafgf","dfwfdyasfd","dhyuwgdyta"};
	String [] sprofile= {"dh","dsad","dsvd"};
	MobileContact mb=new MobileContact("abc", "xyz", number, "abc@gmail.com", related, "ms", "www.abc.com", "cali", sprofile, fl);
//create object for mapper
	ObjectMapper objm=new ObjectMapper();
	//read value
	objm.writeValue(new File("./contact"), mb);
}}
