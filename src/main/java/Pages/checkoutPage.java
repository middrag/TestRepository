package Pages;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;


import base.BasePage;



public class checkoutPage extends BasePage {


	public WebDriver driver;
	
	public String newEmail;
	


	public checkoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Delivery info fields

	
	@FindBy(id="cartimize")
	public List<WebElement> cartimizePageID;
	
	@FindBy(id="cartimize-cart")
	public List<WebElement> cartimizeCartID;
	
	@FindBy(id="order-summary-main-container")
	public List<WebElement> itemsummaryModal;
	
	@FindBy(id = "cartimize-delivery-info")
	public WebElement delivery_info;
	
	//checkout page 
	
	@FindBy(css="a.cartimize-blog-name")
	public WebElement logoLocation;
	
	@FindBy(xpath="//*[@id=\"clc-container\"]/header/div/div[1]/div/a")
	public WebElement siteName;
	
	@FindBy(css="div.sec-badge")
	public WebElement secBadge;
	
	//Step IDs
	
	@FindBy(css="h3.clc-entry-title")
	public WebElement contactHeadertext;
	
	@FindBy(css="div.address-form.woocommerce-shipping-fields")
	public List<WebElement> shippingFields;
	
	
	
	
	

	@FindBy(id = "billing_email")
	public WebElement email;

	@FindBy(id = "createaccount")
	public WebElement create_acc_checkbox;

	// Address details

	@FindBy(id = "shipping_full_name")
	public WebElement shipping_name;

	@FindBy(partialLinkText = "Add a company name (Optional)")
	public WebElement company_optionlink;

	@FindBy(id = "shipping_company")
	public WebElement shipping_company;

	@FindBy(id = "shipping_address_1")
	public WebElement street_addr1;

	@FindBy(partialLinkText = "Add another address line (Optional)")
	public WebElement addres_optionlink;

	@FindBy(id = "shipping_address_2")
	public WebElement street_addr2;

	@FindBy(id = "shipping_city")
	public WebElement ship_city;

	@FindBy(xpath = "//*[@id=\"select2-shipping_state-container\"]")
	public WebElement statecounty;

	@FindBy(id = "shipping_postcode")
	public WebElement ship_postcode;

	@FindBy(id = "select2-shipping_country-container")
	public WebElement ship_country;

	@FindBy(id = "shipping_phone")
	public WebElement ship_phone;

	@FindBy(id = "cartimize-delivery-info-continue")
	public WebElement continue_delinfo_btn;

	@FindBy(id = "cartimize-delivery-info")
	public WebElement delivery_summary;

	@FindBy(xpath = "//*[@id=\"cartimize-delivery-info\"]/div[2]/div/a")
	public WebElement delivery_summary_edit;

	// shipping method

	@FindBy(id = "cartimize-shipping-method-continue")
	public WebElement continue_shipping_btn;

	@FindBy(id = "cartimize-shipping-method")
	public WebElement shipping_method_summary;

	@FindBy(xpath = "//*[@id=\"cartimize-shipping-method\"]/div[2]/div/a")
	public WebElement shipmtd_summary_edit;

	// Payment details step
	
//	@FindBy(css="div.clc-step.unfilled")  // for check payment step opening for editing not  "unopened state"
//	public List<WebElement> cartimizePaymentStepunfilled;
//	
//	@FindBy(css="div.clc-step.unfilled")  // for check payment step opening for editing not  "unopened state"
//	public List<WebElement> cartimizePaymentStepunfill
	
	@FindBy(id = "cartimize-payment-method")
	public WebElement payment_method_stepform;

	//checking same as delivery address present
	@FindBy(id="cartimize-shipping-same-billing")
	public List<WebElement> sameDeliveryAddressCheck;
	
	@FindBy(xpath = "//*[@id=\"cartimize-shipping-same-billing\"]/div[1]/div[1]/label")
	public WebElement same_Dlvry_address;

	@FindBy(xpath = "//*[@id=\"cartimize-shipping-same-billing\"]/div[1]/div[2]/label")
	public WebElement different_Dlvry_address;

	@FindBy(id = "cartimize-same-as-shipping-summary-container")
	public WebElement same_billing_address_summary;

	// Billing Address details
	
	@FindBy(xpath="//div[@class=\"form-container payment-form\"]/div[3]")
	public List<WebElement> billingAddrLabel;
	
	

	
	
	
	public int count(WebElement web)
	{
		List<WebElement> mid=new ArrayList<WebElement>() ;
		mid.add(web);
		System.out.println(mid.size());
		
		return mid.size();
		
	}

	@FindBy(id = "billing_full_name")
	public WebElement billing_name;
	

	@FindBy(linkText = "Add a company name (Optional)")
	public WebElement billing_company_optionlink;
	
	@FindBy(linkText="Add a company name (Optional)")
	public List<WebElement> billingcompanyoptional;
	

	@FindBy(id = "billing_company")
	public WebElement billing_company;

	
	@FindBy(id = "billing_company")
	public List<WebElement> billing_com;

	
	
	@FindBy(id = "billing_address_1")
	public WebElement billing_street_addr1;
	
	
	@FindBy(partialLinkText = "Add another address line (Optional)")
	public List<WebElement> billing_addres_optionalcnt;

	@FindBy(partialLinkText = "Add another address line (Optional)")
	public WebElement billing_addres_optionlink;
	
	
	@FindBy(id = "billing_address_2")
	public List<WebElement> billing_address2_cnt;
	
	@FindBy(id = "billing_address_2")
	public WebElement billing_street_addr2;

	@FindBy(id = "billing_city")
	public WebElement billing_city;

	@FindBy(id = "select2-billing_state-container")
	public WebElement billing_statecounty;

	@FindBy(id = "billing_postcode")
	public WebElement bill_postcode;

	@FindBy(id = "select2-billing_country-container")
	public WebElement bill_country;

	@FindBy(id = "billing_phone")
	public WebElement bill_phone;
	
	
	@FindBy(linkText = "Add a discount code")
	public List<WebElement> discountlinkcnt;

	@FindBy(linkText = "Add a discount code")
	public WebElement discountlink;
	
	

	@FindBy(id = "cartimize-promo-code")
	public List<WebElement> disount_field_cnt;
	
	@FindBy(id = "cartimize-promo-code")
	public WebElement disount_field;
	
	

	@FindBy(id = "cartimize-promo-code-btn")
	public WebElement disount_apply_btn;

	@FindBy(id = "cartimize-payment-method-continue")
	public WebElement continue_paymnt_btn;

	@FindBy(id = "cartimize-payment-method")
	public WebElement payment_method_summary;

	@FindBy(xpath = "//*[@id=\"cartimize-payment-method\"]/div[2]/div/a")
	public WebElement payment_summary_edit;

	@FindBy(id = "terms")
	public WebElement terms_checkbox;

	@FindBy(id = "cartimize-place-order")
	public WebElement placeorder;

	// Stripe

	@FindBy(id = "stripe-card-element")
	public WebElement stripe_card;

	@FindBy(name = "exp-date")
	public WebElement expdate;

	@FindBy(id = "stripe-cvc-element")
	public WebElement stripe_card_cvv;

	// order summary
	@FindBy(partialLinkText = "Add a note to this order")
	public WebElement order_notes_ink;

	@FindBy(id = "order_comments")
	public WebElement order_comments_txtbox;

	@FindBy(css = "tr.cart-subtotal")
	public WebElement cart_subtotal;

	@FindBy(css = "tr.woocommerce-shipping-totals")
	public WebElement cart_shipping;

	@FindBy(css = "tr.order-total .simple-product")
	public WebElement overall_total;

	// order summary cart
	@FindBy(id = "cartimize-cart")
	public WebElement order_summary_itemlocation;

	public void fillEmail(String emailval) {
		email.sendKeys(emailval);
	}

	public void selectCreateacct() {
		create_acc_checkbox.click();
	}

	public void shippingAddressFill(String Name, String companyName, String address1, String address2, String city,
			String countystateprovision, String countryname, String zipcode, String phonenumber) {
		shipping_name.sendKeys(Name);
		company_optionlink.click();
		shipping_company.sendKeys(companyName);
		street_addr1.sendKeys(address1);
		addres_optionlink.click();
		street_addr2.sendKeys(address2);
		ship_city.sendKeys(city);
		select(ship_country, countryname);
		select(statecounty, countystateprovision);
		ship_postcode.sendKeys(zipcode);
		ship_phone.sendKeys(phonenumber);

	}

	public void billingAddressFill(String Name, String companyName, String address1, String address2, String city,
			String countystateprovision, String countryname, String zipcode, String phonenumber) {
		billing_name.sendKeys(Name);
		billing_company_optionlink.click();
		shipping_company.sendKeys(companyName);
		billing_street_addr1.sendKeys(address1);
		billing_addres_optionlink.click();
		billing_street_addr1.sendKeys(address2);
		billing_city.sendKeys(city);
		select(bill_country, countryname);
		select(billing_statecounty, countystateprovision);
		bill_postcode.sendKeys(zipcode);
		bill_phone.sendKeys(phonenumber);

	}

	public void couponFill(String couponcode) {
		discountlink.click();
		disount_field.clear();
		disount_field.sendKeys(couponcode);
		disount_apply_btn.click();

	}

	public void stripeFill(String cardnumber, String monthyear, String cvv) {
		stripe_card.sendKeys(cardnumber);
		expdate.sendKeys(monthyear);
		stripe_card_cvv.sendKeys(cvv);

	}

	public void select(WebElement ele, String statenameorcountry) {
		Select state = new Select(ele);
		state.selectByVisibleText(statenameorcountry);
	}
}
