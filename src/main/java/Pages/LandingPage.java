package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement email; 
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductPage launchApplication(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		ProductPage product = new ProductPage(driver);
		return product;
	}
}
