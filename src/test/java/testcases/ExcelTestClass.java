package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartimizeLoginPage;
import Pages.CartimizeSettingsPage;
import Pages.WooSettingsPage;
import Pages.WordpressAdminPage;
import Pages.WordpressLoginpage;
import utilities.DatUtils;

/**
 * @author midhu
 *
 */
public class ExcelTestClass {


	public WebDriver driver;
	DatUtils ut=new DatUtils();
	public String newEmail;
	


	
	@BeforeTest
	@SuppressWarnings({ "static-access", "deprecation" })
	public void Open()
	{
		//DatUtils ut=new DatUtils();
		System.setProperty("webdriver.chrome.driver", "D:\\downloaded softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ut.setExcelLocation("C:\\Users\\midhu\\eclipse-workspace\\CarttimizeTestngAutomation\\src\\test\\resources\\testdata.xlsx");
		
		
		
	}
	

	
	public void setvalue(String TestSuiteName)
	{
		
		ut.setValue(TestSuiteName);
		System.out.println(TestSuiteName);
	}
	
	@Test(priority=1)
	public void loginsite()
	{
		driver.get("https://mba.rxforge.in/mba_cart34/wp-admin");
		WordpressLoginpage wpage=new WordpressLoginpage(driver);
		wpage.login_wp("midhubala", "midhubala");
		WordpressAdminPage wpadmin=new WordpressAdminPage(driver);
    	wpadmin.woo_settings_select();
    	WooSettingsPage woosettings=new WooSettingsPage(driver);
    	woosettings.cartimizeSelect();
    	setvalue("CREATION");
	}
	
	
    @Test(priority=3,dataProviderClass=DatUtils.class,dataProvider="dp")
	public void createUser(String casenumber, String email, String expectedResult) {

		System.out.println(casenumber + "--------" + email + "------" + expectedResult);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		CartimizeLoginPage clp = new CartimizeLoginPage(driver);
		CartimizeSettingsPage csp = new CartimizeSettingsPage(driver);
		// clp.createAccount(email);
//		boolean res = clp.loginError.getText().contentEquals(expectedResult);
//		System.out.println(res);
//		SoftAssert sasrt=new SoftAssert();
		System.out.println("login form present check" + clp.loginFormLocation.size());
		if (clp.loginFormLocation.size() != 0) {
			if (casenumber.contains("6")) {
				newEmail = ut.randomEmail("midhubala1990");
				System.out.println("new Email" + newEmail);
				clp.createAccount(newEmail);
			} else {
				clp.createAccount(email);
			}

			// wait.until(ExpectedConditions.invisibilityOf(clp.loadingClass));

			if (casenumber.contains("5")) {
				System.out.println("if condition check " + email);
				wait.until(ExpectedConditions.visibilityOf(clp.login_pass));
				String actual = clp.loginError.getText();
				System.out.println("actual Result" + actual);
				System.out.println("Expected Result" + expectedResult);
				Assert.assertEquals(actual, expectedResult);

			} else if (casenumber.contains("6")) {
				wait.until(ExpectedConditions.invisibilityOfAllElements(clp.loginFormLocation));

				if (csp.cart_setting_pageclass.getText().contains(newEmail)) {

					Assert.assertTrue(true);
					setvalue("SETTINGPAGECHECK");
				} else {
					Assert.assertTrue(false, "Test Failes no Email Found on the page.");
				}
			} else {
				String actual = clp.loginError.getText();
				System.out.println("actual Result" + actual);
				System.out.println("Expected Result" + expectedResult);
				Assert.assertEquals(actual, expectedResult);
			}

			driver.navigate().refresh();

		} else {
			Assert.assertFalse(false, "condition Fails");
		}

		// setvalue("SETTINGPAGECHECK");

	}
   // dependsOnMethods="createUser"	

     @Test(dependsOnMethods="createUser",dataProviderClass=DatUtils.class,dataProvider="dp")
    public void createdUserCases(String caseNumber,String ExpectedResult) {
    	 CartimizeSettingsPage csp=new CartimizeSettingsPage(driver);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0,1000)");
    	 
//			if (caseNumber.contains("1")) {
//
//				if (csp.enable_LCW.isSelected()) {
//					Assert.assertTrue(true);
//				} else {
//					Assert.assertFalse(false, "LCW option is not selected");
//				}
//
//			}else if(caseNumber.contains("2"))
//			{
//				if (csp.useTextradio.isSelected()) {
//					Assert.assertTrue(true);
//				} else {
//					Assert.assertFalse(false, "LCW option is not selected");
//				}
//			}else if(caseNumber.contains("3"))
//			{
//				if (csp.useTextradio.isSelected()) {
//					Assert.assertTrue(true);
//				} else {
//					Assert.assertFalse(false, "LCW option is not selected");
//				}
//			}
    	 
    	 switch(caseNumber) //1.0 excel reads values as string so it adds .0 after the value
    	 {
			case "1.0":
				if (csp.useTextradio.isSelected()) {
					Assert.assertTrue(true);
				} else {
					Assert.assertFalse(false, "LCW option is not selected");
				}
				break;
			case "2.0":
				if (csp.useTextradio.isSelected()) {
					Assert.assertTrue(true);
				} else {
					Assert.assertFalse(false, "LCW option is not selected");
				}
				break;
			case "3.0":
				if(csp.useImageRadio.isSelected()) {
					Assert.assertFalse(false,"Image option selected instead of use text option");
				}
				else
				{
					Assert.assertTrue(true);
				}
				break;
			case "4.0":
				if(csp.hideCouponField.isSelected())
				{
					Assert.assertFalse(false,"hide coupon option selected instead defaultly");
				}
				else
				{
					Assert.assertTrue(true);
				}
				break;
			case "5.0":
				if(csp.customCssSelector.isSelected())
				{
					Assert.assertFalse(false,"custom css selector  option selected instead defaultly");
				}
				else
				{
					System.out.println("midhu");
					Assert.assertTrue(true);
				}
				break;
			case "6.0":
				boolean ch=csp.helpUsImprove.isDisplayed();
				System.out.println(ch);
				if(ch==true)
				{
					if (csp.helpUsImprove.isSelected()) {
						Assert.assertTrue(true);
						System.out.println("midhu1");
					} else {
						Assert.assertFalse(false, "help us Improve option is not selected");
					}
					
				}
				break;
			case "7.0":
				if(csp.cart_setting_pageclass.getText().contains(newEmail))
				{
					System.out.println("midhu2");
					Assert.assertTrue(true);
				} else {
					Assert.assertFalse(false, "Created Email ID not present in the Cartimize settings page");
				}
				break;
			case "8.0":
				if(csp.cart_setting_pageclass.getText().contains("Logout"))
				{
					System.out.println("midhu3");
					Assert.assertTrue(true);
				} else {
					Assert.assertFalse(false, "Logout link is not opresent in the page");
				}
				break;
			case "9.0":
				if(csp.becomensideclass.size()!=0)
				{
					System.out.println("midhu4");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "Become insider modal is not present in the page");
				}
				break;
			case "10.0":
				if(csp.feedBack.size()!=0)
				{
					System.out.println("midhu5");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "Feedback modal is not present in the page");
				}
				break;
			case "11.0":
				if(csp.emailAddress.getText().contains(newEmail))
				{
					System.out.println("midhu6");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "Email  not present in the Enter your Email ID text box");
				}
				break;
			case "12.0":
				
				if(csp.productUpdate.isSelected())
				{
					System.out.println("midhu7");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "Product update option not selected Defaultly");
				}
				break;
			case "13.0":
				if(csp.promotionalEmails.isSelected())
				{
					System.out.println("midhu8");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "Promotional Emails not Selected Defaultly");
				}
				break;
			case "14.0":
				if(csp.save_button.isDisplayed())
				{
					System.out.println("midhu9");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "save changes button not Selected Defaultly");
				}
				break;
			case "15.0":
				if(csp.becomeInsider.isDisplayed())
				{
					System.out.println("midhu10");
					Assert.assertTrue(true);
				}else {
					Assert.assertFalse(false, "become insider button not Selected Defaultly");
				}
				break;
				
				
    	 }
    	
    }
     
     
}
