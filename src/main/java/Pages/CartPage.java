package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> cartTitle;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkButton;
	
	public Boolean verifyCartTitle(String product) {
		Boolean match = cartTitle.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	
	public CheckoutPage goToCheckoutPage() {
		checkButton.click();
		CheckoutPage check = new CheckoutPage(driver);
		return check;
	}
}
