package com.limeroadandroidautomation.pages;

import org.hamcrest.Matchers;

import com.limeroadandroidautomation.bean.LRProductInfoBean;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "productdetailspage.lbl.productname")
	private QAFWebElement productdetailspageLblProductname;
	@FindBy(locator = "productdetailspage.lbl.productprice")
	private QAFWebElement productdetailspageLblProductprice;
	
	
	@FindBy(locator = "productdeatilspage.btn.addtocart")
	private QAFWebElement productdeatilspageBtnAddtocart;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductdetailspageLblProductname() {
		return productdetailspageLblProductname;
	}

	public QAFWebElement getProductdetailspageLblProductprice() {
		return productdetailspageLblProductprice;
	}

	

	public QAFWebElement getProductdeatilspageBtnAddtocart() {
		return productdeatilspageBtnAddtocart;
	}
	
	public void verifyTheProduct()
	{
		getProductdetailspageLblProductname().waitForVisible();
		
		Validator.verifyThat("Product name verification on product details page", getProductdetailspageLblProductname().getText(),Matchers.containsString(LRProductInfoBean.getProductName()));
		Validator.verifyThat("Product price verification on product deatils page", getProductdetailspageLblProductname().getText(), Matchers.containsString(LRProductInfoBean.getProductPrice()));
	}
	
	
	@QAFTestStep(description = "user clicks on Add to Cart btn")

	public void clickOnAddToCart()
	{
		getProductdeatilspageBtnAddtocart().waitForPresent();
		getProductdeatilspageBtnAddtocart().click();
		
	}

}
