package ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

public class ReadDataFromExcelTest {
	public String excelDataTest(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{ 
		FileInputStream fis=new FileInputStream("./Data/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String val;
		
		
		 val = book.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		
	
		
		return val;
	}
	
	
	
	

}
