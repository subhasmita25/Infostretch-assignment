package com.limeroadandroidautomation.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class LrwelcomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "welcomepage.link.shopwomenlink")
	private QAFWebElement welcomepageLinkShopwomenlink;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getWelcomepageLinkShopwomenlink() {
		return welcomepageLinkShopwomenlink;
	}
	@QAFTestStep(description = "user launches the limeroad app")
	public void userLaunchesTheLimeroadApp() {
		
	}
	
	
	@QAFTestStep(description = "user clicks on {0}")
	public void clickonShopForMenOrWomen(String catagory)
	{
		QAFExtendedWebElement q1=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("welcomepage.link.shopwomenlink"), catagory));
		q1.waitForVisible();
		q1.waitForPresent();
		Validator.verifyThat("verifying the visibility of the category", q1.isDisplayed(),Matchers.equalTo(true));

		q1.click();
		
	}

}
