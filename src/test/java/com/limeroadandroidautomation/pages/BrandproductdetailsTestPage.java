package com.limeroadandroidautomation.pages;

import org.hamcrest.Matchers;


import com.limeroadandroidautomation.bean.LRProductInfoBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class BrandproductdetailsTestPage
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {
	
	

	@FindBy(locator = "brandproductdetailspage.lbl.menuitem")
	private QAFWebElement brandproductdetailspageLblMenuitem;
	
	@FindBy(locator = "brandproductdetailspage.lbl.submenuitem")
	private QAFWebElement brandproductdetailspageLblSubmenuitem;
	
	@FindBy(locator = "brandproductdeatilspage.chkbox.itemtype")
	private QAFWebElement brandproductdeatilspageChkboxItemtype;
	
	@FindBy(locator = "brandproductdetailspage.btn.apply")
	private QAFWebElement brandproductdetailspageBtnApply;
	
	@FindBy(locator = "brandproductdetailspage.btn.filter")
	private QAFWebElement brandproductdetailspageBtnFilter;
	@FindBy(locator = "brandproductdetailspage.btn.sort")
	private QAFWebElement brandproductdetailspageBtnSort;
	@FindBy(locator = "brandproductdeatilspage.link.lowtohigh")
	private QAFWebElement brandproductdeatilspageLinkLowtohigh;
	
	@FindBy(locator = "searchresultpage.lbl.price")
	private QAFWebElement searchresultpageLblPrice;
	
	@FindBy(locator = "searchresultpage.lbl.productname")
	private QAFWebElement searchresultpageLblProductname;
	@FindBy(locator = "productdeatilspage.btn.productsize")
	private QAFWebElement productdeatilspageBtnProductsize;
	
	
	public QAFWebElement getSearchresultpageLblPrice() {
		return searchresultpageLblPrice;
	}
	
	public QAFWebElement getSearchresultpageLblProductname() {
		return searchresultpageLblProductname;
	}


	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	
	public QAFWebElement getBrandproductdetailspageLblMenuitem() {
		return brandproductdetailspageLblMenuitem;
	}

	public QAFWebElement getBrandproductdetailspageLblSubmenuitem() {
		return brandproductdetailspageLblSubmenuitem;
	}

	public QAFWebElement getBrandproductdeatilspageChkboxItemtype() {
		return brandproductdeatilspageChkboxItemtype;
	}

	public QAFWebElement getBrandproductdetailspageBtnApply() {
		return brandproductdetailspageBtnApply;
	}

	public QAFWebElement getBrandproductdetailspageBtnFilter() {
		return brandproductdetailspageBtnFilter;
	}

	public QAFWebElement getBrandproductdetailspageBtnSort() {
		return brandproductdetailspageBtnSort;
	}

	public QAFWebElement getBrandproductdeatilspageLinkLowtohigh() {
		return brandproductdeatilspageLinkLowtohigh;
	}
	public QAFWebElement getProductdeatilspageBtnProductsize() {
		return productdeatilspageBtnProductsize;
	}
	@QAFTestStep(description = "user selects the filter icon")
	public void clickOnFilter()
	{
		getBrandproductdetailspageBtnFilter().waitForPresent();
		getBrandproductdetailspageBtnFilter().click();

	}
	@QAFTestStep(description = "user selects the {0} and the price level upto {1}")

	public void selectYourProductByPrice(String byPrice,String priceValue)
	{
		QAFExtendedWebElement parent=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("brandproductdetailspage.lbl.menuitem"), byPrice));
		parent.waitForPresent();
		parent.click();
		
		QAFExtendedWebElement child=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("brandproductdetailspage.lbl.submenuitem"), priceValue));
		child.waitForPresent();
		child.click();
		
//		QAFExtendedWebElement itemType=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("brandproductdeatilspage.chkbox.itemtype"), subType));
//		itemType.waitForPresent();
//		itemType.click();
		//BrandproductdetailsTestPage cApply=new BrandproductdetailsTestPage();
		clickOnApply();
		
	}
	public void clickOnApply()
	{
		getBrandproductdetailspageBtnApply().waitForPresent();
		getBrandproductdetailspageBtnApply().click();
		
	}
	@QAFTestStep(description = "user clicks on sort icon")
	public void clickOnSortBtn()
	{
		getBrandproductdetailspageBtnSort().waitForVisible();
		getBrandproductdetailspageBtnSort().waitForPresent();
		getBrandproductdetailspageBtnSort().click();
		
		QAFTestBase.pause(3000);
	}
	
	@QAFTestStep(description = "user verifies the brandproduct details page on the product list page")

	public void verifyProductList()
	{
		Validator.verifyThat("Product list page verification",getSearchresultpageLblProductname().isDisplayed(), Matchers.equalTo(true));	
	
	}
	@QAFTestStep(description = "user chooses the {0}th product")
	public void selectProduct(int index)
	{
		
		LRProductInfoBean.setProductName(getSearchresultpageLblProductname().getText());
		Reporter.log(getSearchresultpageLblProductname().getText());
		
		LRProductInfoBean.setProductPrice(getSearchresultpageLblPrice().getText());
		Reporter.log(getSearchresultpageLblPrice().getText());
		
		getSearchresultpageLblProductname().click();
		
	}

}
