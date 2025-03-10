package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	 WebElement spinner;
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By productList = By.cssSelector(".mb-3");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productList);
		return products;
	}
	
	public WebElement getProduct(String product) {
		WebElement item =  getProductList().stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		return item;
	}
	
	public void addToCart(String items) throws InterruptedException {
		WebElement pname = getProduct(items);
		pname.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(spinner);
	}

}
