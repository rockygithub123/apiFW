package GenericUtility;

import java.util.Random;

public class JavaUtility {
	public int randomNumber()
	{
		
		Random ran=new Random();
		int rannum = ran.nextInt(500);
		return rannum;
	}

}
