package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.checkoutPage;
import utilities.DatUtils;

public class CheckOutClass {

	public WebDriver driver;
	DatUtils ut=new DatUtils();
	public String newEmail;
	public static String siteName;


	@BeforeTest
	@SuppressWarnings({ "static-access", "deprecation" })
	public void Open() {
		// DatUtils ut=new DatUtils();
		System.setProperty("webdriver.chrome.driver", "D:\\downloaded softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ut.setExcelLocation(
				"C:\\Users\\midhu\\eclipse-workspace\\CarttimizeTestngAutomation\\src\\test\\resources\\testdata.xlsx");

	}

	public void setvalue(String TestSuiteName) {

		ut.setValue(TestSuiteName);
		System.out.println(TestSuiteName);
	}

	@Test(priority = 1)
	public void opensite() {
		siteName = "https://mba.rxforge.in/midSitecheck/";
		driver.get(siteName);
		addcartAndCheckout();
		CheckOutOperation();
	}

	public void addcartAndCheckout() {
		driver.get(siteName + "?add-to-cart=31");
	    driver.get(siteName + "?add-to-cart=23");
		
			}

	public void CheckOutOperation() {


 	driver.get(siteName+"/checkout");
		
		checkoutPage cop=new checkoutPage(driver);
		int checkoutPresent=cop.cartimizePageID.size();
		System.out.println("checkoutPresent"+checkoutPresent);
		
		
	}
}
