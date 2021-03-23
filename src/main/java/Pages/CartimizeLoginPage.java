package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;

public class CartimizeLoginPage extends BasePage {



	public CartimizeLoginPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "cartimize_service_email")
	public WebElement login_email;

	@FindBy(id = "cartimize_service_create_btn")
	public WebElement create_acctBtn;

	
	//create acct label
	@FindBy(id = "create-account")
	public WebElement create_acctLabel;
	
	@FindBy(xpath="//div[@class='acc-login-form create-form']")
	public List<WebElement> loginFormLocation;
	

	@FindBy(xpath = "//label[normalize-space()='Login To Your Account']")
	public WebElement login_to_your_acct_label;
	

	@FindBy(id = "cartimize_service_password")
	public WebElement login_pass;

	@FindBy(linkText = "Forgot password?")
	public WebElement forgot_pass_link;

	@FindBy(id = "cartimize_service_login_btn")
	public WebElement cartimise_login_btn;
	
	@FindBy(id="cartimize_service_login_btn_result") 
	public WebElement loginError;
	
	@FindBy(xpath="//div[@class='button-primary create-content loading']")
	public WebElement loadingClass;

	public void loginCartimize(String email, String pass) {
		login_email.clear();
		login_email.sendKeys(email);
		login_pass.clear();
		login_pass.sendKeys(pass);
		cartimise_login_btn.click();
	}

	public void createAccount(String email) {
		login_email.clear();
		login_email.sendKeys(email);
		create_acctBtn.click();
		
		
	}

}
