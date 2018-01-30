package com.limeroadandroidautomation.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {



	
	
	@FindBy(locator = "searchresultpage.lbl.sort")
	private QAFWebElement searchresultpageLblSort;
	@FindBy(locator = "searchresultpage.link.lowtohigh")
	private QAFWebElement searchresultpageLinkLowtohigh;
	@FindBy(locator = "searchresultpage.lbl.verifypage")
	private QAFWebElement searchresultpageLblVerifypage;
	
	@FindBy(locator="searchresultpage.lbl.brandname")
	private QAFWebElement searchresultpageLblBrandname;
	@FindBy(locator="searchresultpage.lbl.price")
	private QAFWebElement searchresultpageLblPrice;
	@FindBy(locator="searchresultpage.lbl.productname")
	private QAFWebElement searchresultpageLblProductname;
	


	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	

	public QAFWebElement getSearchresultpageLblSort() {
		return searchresultpageLblSort;
	}

	public QAFWebElement getSearchresultpageLinkLowtohigh() {
		return searchresultpageLinkLowtohigh;
	}

	public QAFWebElement getSearchresultpageLblVerifypage() {
		return searchresultpageLblVerifypage;
	}
	public QAFWebElement getSearchresultpageLblBrandname()
	{
		return searchresultpageLblBrandname;
		
	}
	public QAFWebElement getSearchresultpageLblProductname()
	{
		return searchresultpageLblProductname;
		
	}
	
	
	public QAFWebElement getSearchResultPageLblPrice()
	{
		return searchresultpageLblPrice;
		
	}
	
	
	
	public void verifySearchResultPage()
	{
		getSearchresultpageLblVerifypage().waitForPresent();
		Validator.verifyThat("searchresult page verification", getSearchresultpageLblVerifypage().getText(), Matchers.containsString("Choose Your Price Range"));
	}
	
	@QAFTestStep(description = "user selects {0}")
	public void productSortBy(String sortBy)
	{
		QAFExtendedWebElement ele= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("searchresultpage.link.lowtohigh"), sortBy));
		ele.waitForPresent();
		ele.click(); 
	}
	@QAFTestStep(description = "user selects the brand name of the product")
	public void selectBrandName()
	{
		getSearchresultpageLblBrandname().waitForVisible();
		getSearchresultpageLblBrandname().click();
	}

}
