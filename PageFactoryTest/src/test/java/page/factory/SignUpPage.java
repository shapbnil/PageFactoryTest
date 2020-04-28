package page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SignUpPage {
	
	WebDriver driver;
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "confirmEmail")
	public WebElement confirmEmail;
	
	@FindBy(id = "choosePassword")
	public WebElement choosePassword;
	
	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword;
	
	
	@FindBy(xpath = "//*[text()=' I have read and accept the ']")
	public WebElement clickAccept;
	
	@FindBy(xpath = "//button[@id='signup']")
	public WebElement submit;

	public void performSignUp(String str_Email,String cnfEmail,String pwd,String cnfPwd,ExtentTest test) {

		Common common=new Common();
		
		common.enterText(email, str_Email,"Email", test);
		common.enterText(confirmEmail, cnfEmail,"Cnf Email",test);
		common.enterText(choosePassword, pwd,"Password",test);
		common.enterText(confirmPassword, cnfPwd,"Cnf Password",test);
		
		common.clickObj(clickAccept,"Accept",test );
		common.clickObj(submit,"Submit",test);
	}
}
