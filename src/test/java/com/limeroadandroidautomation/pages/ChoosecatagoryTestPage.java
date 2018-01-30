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

public class ChoosecatagoryTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "choosecatagory.link.productname")
	private QAFWebElement choosecatagoryLinkProductname;
	@FindBy(locator = "choosepricelevel.link.productpricelevel")
	private QAFWebElement choosepricelevelLinkProductpricelevel;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getChoosecatagoryLinkProductname() {
		return choosecatagoryLinkProductname;
	}

	public QAFWebElement getChoosepricelevelLinkProductpricelevel() {
		return choosepricelevelLinkProductpricelevel;
	}
	
	
	
	@QAFTestStep(description = "user selects {0} and price level upto {1}")
	public void chooseProduct(String prodName,String priceValue)
	{
		QAFExtendedWebElement e= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("choosecatagory.link.productname"),prodName));
		e.waitForPresent();
		Validator.verifyThat("Choose product page validation", e.getText(), Matchers.containsString(e.getText()));
		e.click();
		
		QAFExtendedWebElement q1=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("choosepricelevel.link.productpricelevel"), priceValue));
		q1.waitForPresent();
		Validator.verifyThat("Choose product page validation", q1.getText(), Matchers.containsString(q1.getText()));

		q1.click();

	}

}
