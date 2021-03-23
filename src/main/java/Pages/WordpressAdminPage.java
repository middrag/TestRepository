package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class WordpressAdminPage extends BasePage {


	
	public WordpressAdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"toplevel_page_woocommerce\"]/a/div[3]")
	public WebElement Woocommerce_menu;
	
	@FindBy(linkText="Settings")
	public WebElement woo_settings;
	
	
	
	public void woo_settings_select()
	{
		Woocommerce_menu.click();
		woo_settings.click();
		
	}
	
	
	
	
	

}
