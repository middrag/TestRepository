package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class WooSettingsPage extends BasePage {



	public WooSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Cartimize")
	public WebElement cartimise_tab;

	@FindBy(linkText = "General")
	public WebElement general_tab;

	@FindBy(linkText = "Products")
	public WebElement products_tab;

	@FindBy(linkText = "Tax")
	public WebElement tax_tab;

	@FindBy(linkText = "Shipping")
	public WebElement shipping_tab;

	@FindBy(linkText = "Payments")
	public WebElement payments_tab;

	@FindBy(linkText = "Accounts & Privacy")
	public WebElement accountsPrivacy_tab;

	@FindBy(linkText = "Emails")
	public WebElement emails_tab;

	@FindBy(linkText = "Integration")
	public WebElement integration_tab;

	@FindBy(linkText = "Advanced")
	public WebElement advanced_tab;

	public void cartimizeSelect() {
		cartimise_tab.click();
	}

	public void GeneralSelect() {

		general_tab.click();
	}

	public void productSelect() {
		products_tab.click();
	}

	public void taxSelect() {
		tax_tab.click();
	}

	public void shippingSelect() {
		shipping_tab.click();
	}

	public void paymentsSelect() {
		payments_tab.click();
	}

	public void accAndPrivacySelect() {
		accountsPrivacy_tab.click();
	}

	public void emailSelect() {
		emails_tab.click();
	}

	public void integrationSelect() {
		integration_tab.click();
	}

	public void advancedSelect() {
		advanced_tab.click();
	}
	
}
