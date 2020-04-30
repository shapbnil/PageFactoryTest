package page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="bx-close-inside-1156777")
	public WebElement NextTrip;
	
	
	@FindBy(xpath = "//*[text()='Log in/Sign up']")
	public WebElement ClickSingUp;

	@FindBy(xpath = "//*[text()=' Sign up ']")
	public WebElement signup;
}
