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

public class AddtocartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "addtocart.button.proceedtocart")
	private QAFWebElement addtocartButtonProceedtocart;
	
	@FindBy(locator = "cancel.button.addtocart")
	private QAFWebElement cancelButtonAddtoCart;

	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getAddtocartButtonProceedtocart() {
		return addtocartButtonProceedtocart;
	}
	public QAFWebElement getCancelButtonAddtoCart() {
		return cancelButtonAddtoCart;
	}
	
	
	@QAFTestStep(description = "user verifies the product on the add to cart page")
	public void selectProceedToCart()
	{
		getAddtocartButtonProceedtocart().waitForPresent();
		getAddtocartButtonProceedtocart().click();
		
		verifyProductOnCart();
	}

	public void verifyProductOnCart()
	{
		SearchresultTestPage page= new SearchresultTestPage();
				Validator.verifyThat(page.getSearchresultpageLblProductname().getText(), Matchers.containsString(LRProductInfoBean.getProductName()));
				//Validator.verifyThat(page.getSearchResultPageLblPrice().getText(), Matchers.containsString(LRProductInfoBean.getProductPrice()));
				
				getCancelButtonAddtoCart().waitForPresent();
				getCancelButtonAddtoCart().click();
	}

}
