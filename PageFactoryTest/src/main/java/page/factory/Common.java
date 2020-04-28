package page.factory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Common {

	public WebDriver lunchBrowser(String browser,ExtentTest test) {
		WebDriver driver = null;
		try {
			if (browser == null) {
				Properties prop = new Properties();
				prop.load(new FileInputStream("conf.properties"));

				browser = prop.getProperty("Browser");
			}

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			System.out.println("Successfully lauch browser " + browser);
			test.log(Status.PASS, "Successfully lauch browser " + browser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failure to lauch browser " + browser);
			test.log(Status.FAIL, "Failure to lauch browser " + browser);
		}

		return driver;
	}

	public void navigateUrl(WebDriver driver,ExtentTest test) {
		String environment = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("conf.properties"));

			environment = prop.getProperty("Environment");
			String url = null;
			if (environment.equalsIgnoreCase("qa")) {
				url = prop.getProperty("QA_Url");
			} else if (environment.equalsIgnoreCase("dev")) {
				url = prop.getProperty("Dev_Url");
			} else if (environment.equalsIgnoreCase("stag")) {
				url = prop.getProperty("Stag_Url");
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Successfully navigate url " + environment);
			test.log(Status.PASS, "Successfully navigate url " + environment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failure to navigate url " + environment);
			test.log(Status.FAIL, "Failure to navigate url " + environment);
		}

	}

	public void clickObj(WebElement ele, String msg, ExtentTest test) {
		try {
			ele.click();
			System.out.println("Successfully click " + msg);
			test.log(Status.PASS, "Successfully Click " + msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
			test.log(Status.FAIL, "Failure to Click " + msg);
		}
	}

	public void enterText(WebElement ele, String input, String msg, ExtentTest test) {

		try {
			ele.sendKeys(input);
			System.out.println("Successfully enter text " + msg);
			test.log(Status.PASS, "Successfully enter text" + msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failure to enter text " + msg);
			test.log(Status.FAIL, "Failure to EnterText " + msg);
		}
	}

	public void tearDown(WebDriver driver) {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}