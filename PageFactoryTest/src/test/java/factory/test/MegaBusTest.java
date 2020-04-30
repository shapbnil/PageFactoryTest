package factory.test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.factory.Common;
import page.factory.ExcelOperations;
import page.factory.HomePage;
import page.factory.SignUpPage;

public class MegaBusTest {
	
	@Test
	@Parameters("browser")
	public void registrationPF(@Optional String browser123) {
		
		//Test data
		ExcelOperations ep= new ExcelOperations();
		XSSFSheet sheet =ep.readDataFromExcel(System.getProperty("user.dir")+"\\Test-Data\\SignUp_Data.xlsx", "Sign_UP");
		XSSFRow row =sheet.getRow(1);
		
		String email = row.getCell(0).getStringCellValue();
		String cnf_Email = row.getCell(1).getStringCellValue();
		String pwd = row.getCell(2).getStringCellValue();
		String cnf_Pwd = row.getCell(3).getStringCellValue();
		
		//Report
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\Report.html");
		ExtentReports extent =new ExtentReports();
		ExtentTest test= extent.createTest("Test1");
		extent.attachReporter(htmlReport);
		
		//Functionality
		Common common=new Common();
		WebDriver driver= common.lunchBrowser(browser123,test);
		common.navigateUrl(driver,test);
				
		HomePage hp= new HomePage(driver);
		common.clickObj(hp.NextTrip, "NextTrip", test);
		common.clickObj(hp.ClickSingUp,"SingUp", test);
		common.clickObj(hp.signup,"Signup", test);
		
		SignUpPage sp= new SignUpPage(driver);
		sp.performSignUp(email,cnf_Email,pwd,cnf_Pwd,test);
		
		common.tearDown(driver);		
		extent.flush();
	}
	
		
}
