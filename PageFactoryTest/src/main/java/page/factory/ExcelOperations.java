package page.factory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public XSSFSheet readDataFromExcel(String filePath, String sheetName) {
		XSSFSheet sheet=null;
		try {
			FileInputStream file = new FileInputStream(new File(filePath));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheet(sheetName);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// Read operations File InputStream
		

		
		
		return sheet;
	}

	
}
