package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement tbox;
	
	@FindBy(css=".list-group-item")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement placeButton;
	
	public void selectCountry(String country) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(tbox,country).build().perform();
		Thread.sleep(2000);
		WebElement India = countryList.stream().filter(s->s.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		India.click();
	}
	
	public void placeOrder() throws InterruptedException {
		Thread.sleep(2000);
		placeButton.click();
	}
}
