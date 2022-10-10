package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

public class ExcelUtiliyt {
	/**
	 * this method used to get data from excel sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String excelDataTest(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Data/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);



		String val = book.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();

		book.close();

		return val;
	}
	/**
	 * this method is used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Data/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);



		Sheet sh = book.getSheet("Sheet1");
		book.close();
		return sh.getLastRowNum(); 
	}

}
