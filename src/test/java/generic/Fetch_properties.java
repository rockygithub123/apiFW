package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Fetch_properties {


		public static String getProperties() throws IOException
		{
			FileInputStream fi=new FileInputStream("C:\\project\\ide\\rocky_api\\src\\test\\java\\utils\\global_properties");
			Properties p=new Properties();
			p.load(fi);
			String a1 = p.getProperty("baseuri");
			return a1;
		}

	}


