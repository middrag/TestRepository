package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartimizeSettingsPage extends BasePage {



	public CartimizeSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement web;


	@FindBy(xpath="//div[@class='email-optin-cont']")
	public List<WebElement> becomensideclass;
	
	@FindBy(xpath="//div[@class='beta-program-cont']")
	public List<WebElement> feedBack;
	
	@FindBy(xpath = "//label[normalize-space()='Enable the Linear Checkout']")
	public WebElement enable_LCW;
	
	@FindBy(className="cartimize_checkopt_settings_page")
	public WebElement cart_setting_pageclass;
	
	@FindBy(xpath="//label[normalize-space()='Use image']")
	public WebElement useImageRadio;
	@FindBy(xpath="//input[@value='text']")
	public WebElement useTextradio;
	@FindBy(id="cartimize-store-text")
	public WebElement useTextTextbox;
	
	@FindBy(xpath="//label[normalize-space()='Enable custom CSS']")
	public WebElement customCssSelector;
	
	@FindBy(xpath="//div[@class='CodeMirror-scroll']")
	public WebElement customSelectorEditor;
	
	@FindBy(xpath="//label[normalize-space()='Hide the coupon field in the checkout page']")
	public WebElement hideCouponField;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/div[11]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[1]/label[1]/input[1]")
	public WebElement helpUsImprove;
	
	
	@FindBy(xpath = "//*[@id=\"mainform\"]/p/button")
	public WebElement save_button;
	@FindBy(className = "suggest-feature")
	public WebElement feature;
	@FindBy(className = "report-bug")
	public WebElement report_bug;
	@FindBy(className = "get-support")
	public WebElement get_support;
	
	@FindBy(linkText="Logout")
	public WebElement logout;
	
	
	
	@FindBy(id="cartimize-email-subscription")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@class='cartimize-product-update']")
	public WebElement productUpdate;
	
	@FindBy(xpath="//input[@class='cartimize-promotional-email']")
	public WebElement promotionalEmails;
	
	@FindBy(id="cartimize-keep-me-updated")
	public WebElement becomeInsider;
	
	
	public void select_productUpdate() {
		if (!productUpdate.isSelected()) {
			productUpdate.click();
		}
	}
	
	public void unSelect_productUpdate() {
		if (productUpdate.isSelected()) {
			productUpdate.click();
		}
	}
	
	public void select_promotionaEmails() {
		if (!promotionalEmails.isSelected()) {
			promotionalEmails.click();
		}
	}
	
	public void unSelect_promotionaEmails() {
		if (promotionalEmails.isSelected()) {
			promotionalEmails.click();
		}
	}
	
	

	
	public void select_helpusImprove() {
		if (!helpUsImprove.isSelected()) {
			helpUsImprove.click();
			save_button.click();
		}
	}


	
	public void unselect_helpusImprove() {
		if (helpUsImprove.isSelected()) {
			helpUsImprove.click();
			save_button.click();
		}
	}
	
	public void select_csutomCssRadiobutton() {
		if (!customCssSelector.isSelected()) {
			customCssSelector.click();
			save_button.click();
		}
	}


	
	public void unSelect_csutomCssRadiobutton() {
		if (customCssSelector.isSelected()) {
			customCssSelector.click();
			//save_button.click();
		}
	}
	

	public void select_hideCouponField() {
		if (!hideCouponField.isSelected()) {
			hideCouponField.click();

		}
	}

	public void unselect_hideCouponField() {
		if (hideCouponField.isSelected()) {
			hideCouponField.click();
		}
	}
	
	
	
	public void enable_LCW() {
		if (!enable_LCW.isSelected()) {
			enable_LCW.click();
			save_button.click();
		}

	}

	public void disable_LCW() {
		if (enable_LCW.isSelected()) {
			enable_LCW.click();
			save_button.click();
		}

	}

	
	
	public boolean checkLinkfeedback(String link, String feedbacktype) {

		if (feedbacktype == "feature") {
			web = feature;
		} else if (feedbacktype == "bug") {
			web = report_bug;
		} else if (feedbacktype == "support") {
			web = get_support;
		}
		if (!web.getText().contains(link))
			return false;
		return true;

	}
	
	/*
	 * public boolean checkLinkBug(String link) {
	 * 
	 * if (!report_bug.getText().contains(link)) return false; return true;
	 * 
	 * } public boolean checkLinkSupport(String link) {
	 * 
	 * if (!get_support.getText().contains(link)) return false; return true;
	 * 
	 * }
	 */
	
	
}
