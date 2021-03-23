package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class CommonUtilities extends BasePage{



	
	public CommonUtilities(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void mouse_hover_action(WebElement ele)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.build().perform();
	}
}
