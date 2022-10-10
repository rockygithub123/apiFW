package GenericUtility;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

import ExcelUtility.ReadDataFromExcelTest;

public class DataProvider {
	public Object[][] TestBody(int set,int values) throws EncryptedDocumentException, IOException
	{
		Object[][] obj=new Object[set][values];
		ReadDataFromExcelTest excel=new ReadDataFromExcelTest();


		for (int i = 0; i < set; i++) {
			for (int j = 0; j < values; j++) {
				if(j!=3) {
					String val = excel.excelDataTest(i, j);

					obj[i][j]=val;


				}
				else if(j==1)
				{
					int ran = new Random().nextInt(500);
					String val = excel.excelDataTest(i, j)+ran;

					obj[i][j]=val;

				}
				else
				{
					String val = excel.excelDataTest(i, j);


					obj[i][j]=Integer.parseInt(val);

				}

			}
		}


		return obj;
	} 

}
