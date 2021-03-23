package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.checkoutPage;
import utilities.DatUtils;

public class test {
	public WebDriver driver;
	public String siteName;
	DatUtils ut = new DatUtils();

	checkoutPage cp;

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\\\downloaded softwares\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ut.setExcelLocation(
				"C:\\\\Users\\\\midhu\\\\eclipse-workspace\\\\CarttimizeTestngAutomation\\\\src\\\\test\\\\resources\\\\testdata.xlsx");

	}

	public void addProducts(String productName, String sitenmae) {

		siteName = sitenmae;
		if (productName == "virtual") {
			driver.get(siteName + "?add-to-cart=31");
			driver.get(siteName + "checkout");
		} else if (productName == "physical") {
			driver.get(siteName + "?add-to-cart=23");
			driver.get(siteName + "checkout");
		} else if (productName == "combined") {
			driver.get(siteName + "?add-to-cart=31");
			driver.get(siteName + "?add-to-cart=23");
			driver.get(siteName + "checkout");
		} else {
			System.out.println("Prodcut is empty please input the product");
		}
	}

	@Test(priority = 1)
	public void virtual_product_TestCases() {
		addProducts("virtual", "https://mba.rxforge.in/midSitecheck/");
		ut.setValue("CHECKOUT_VIRTUAL");
		cp = new checkoutPage(driver);
		int cnt = cp.cartimizePageID.size();
		System.out.println("cartimize page ID" + cnt);
		if (cnt < 1) {
			Assert.assertFalse(true, "Checkout Page not present for testing checkout cases");

		}

	}

//  @Test(priority=2,dependsOnMethods="virtual_product_TestCases",dataProviderClass=DatUtils.class,dataProvider="dp")
	public void virtual_UIUX_ContactInfo(String caseNumber, String expectedResult) {
		SoftAssert softAssertion = new SoftAssert();

		int cnt = cp.cartimizePageID.size();
		// System.out.println("cartimize page ID"+cnt);
		if (cnt > 0) {
			// System.out.println(caseNumber);
			double d = Double.parseDouble(caseNumber);
			int caseValue = (int) d;

			// System.out.println("caseValue"+i);
			switch (caseValue) {
			case 1:
				softAssertion.assertTrue(cp.siteName.getText().contains(expectedResult));
				break;
			case 2:

				if (cp.secBadge.isDisplayed()) {

					softAssertion.assertTrue(cp.secBadge.getText().contains(expectedResult));
				} else {
					softAssertion.assertFalse(true);
				}
				break;
			case 3:

				softAssertion.assertTrue(cp.itemsummaryModal.size() > 0);
				break;
			case 4:
				softAssertion.assertFalse(cp.contactHeadertext.getText().contains("asd"));
				break;
			case 5:
				softAssertion.assertTrue(cp.shippingFields.size() < 1);
				break;
			case 6:
				softAssertion.assertTrue(cp.continue_shipping_btn.getAttribute("value").contains(expectedResult));
				break;
			case 7:
				try {
					cp.fillEmail("midhubala1990@gmail.com");
					cp.continue_shipping_btn.click();
					WebDriverWait wait = new WebDriverWait(driver, 15);

					wait.until(ExpectedConditions.attributeContains(cp.delivery_info, "class", "filled"));
					System.out.println(cp.payment_method_stepform.getAttribute("class"));
					Assert.assertTrue(cp.payment_method_stepform.getAttribute("class").contains(expectedResult));
				} catch (Exception e) {
					Assert.assertFalse(true, "Page not opening");
				}

				break;
			case 8:
				Assert.assertTrue(cp.siteName.getAttribute("href").contains(siteName + expectedResult));
				// driver.close();
				break;

			}

		} else {
			Assert.assertFalse(true, "cartimize checkot page not showing for checking cases");
		}
		softAssertion.assertAll();
	}

	@Test(priority = 3)
	public void virtual_paymentUICases_open() {

		ut.setValue("VIRTUAL_PAYMENTSTEP");
		cp.fillEmail("midhubala1990@gmail.com");
		cp.continue_shipping_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.attributeContains(cp.delivery_info, "class", "filled"));
	}

	@Test(priority = 4, dependsOnMethods = "virtual_paymentUICases_open", dataProviderClass = DatUtils.class, dataProvider = "dp")
	public void virtual_UIUX_paymentStep(String caseNumber, String expectedResult) {

		System.out.println("caseNumber" + caseNumber + "expectedResult" + expectedResult);

		int cnt = cp.cartimizePageID.size();
		// System.out.println("cartimize page ID"+cnt);
		if (cnt > 0) {
			double dvalue = Double.parseDouble(caseNumber);
			int caseValue = (int) dvalue;
			System.out.println("payment double value" + caseValue);
			switch (caseValue) {
			case 1:
				Assert.assertTrue(cp.sameDeliveryAddressCheck.size() < 1);

				break;
			case 2:
				Assert.assertTrue(cp.order_summary_itemlocation.getText().contains(expectedResult));

				break;
			case 3:

				int check = cp.billingAddrLabel.size();

				if (check > 0) {
					List<WebElement> we = cp.billingAddrLabel;
					Iterator<WebElement> ele = we.iterator();
					if (ele.hasNext()) {

						System.out.println("no next element Present");
						Assert.assertTrue(ele.next().getText().contains(expectedResult));

					} else {
						Assert.assertFalse(true);
					}
				} else {
					Assert.assertFalse(true, "billing address lable is not presenting");
				}
			case 4:

				Assert.assertTrue(cp.billingcompanyoptional.size() > 0 && cp.billing_company.getText().contains(expectedResult));
				break;

			case 5:
				Assert.assertTrue(cp.billing_addres_optionalcnt.size() > 0 && cp.billing_addres_optionlink.getText().contains(expectedResult));
				break;
			case 6:
				cp.billing_company_optionlink.click();

				Assert.assertTrue(cp.billing_com.size() > 0);

				break;
			case 7:
				cp.billing_addres_optionlink.click();
				Assert.assertTrue(cp.billing_address2_cnt.size()>0);
				break;
			case 8:
				if(cp.discountlinkcnt.size()>0 && cp.discountlink.getText().contains(expectedResult))
				{
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertFalse(true);
				}
			}

		}

	}

	@Test(priority = 5)
	public void namecheck() {

		System.out.println("midhubala check");

	}

}
