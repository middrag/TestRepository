package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class WordpressLoginpage extends BasePage {



	public WordpressLoginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "user_login")
	public WebElement wp_usrname;
	@FindBy(id = "user_pass")
	public WebElement wp_pass;
	@FindBy(id = "wp-submit")
	public WebElement wp_submit;

	public void login_wp(String username, String password) {
		wp_usrname.sendKeys(username);
		wp_pass.sendKeys(password);
		wp_submit.click();
	}

}
