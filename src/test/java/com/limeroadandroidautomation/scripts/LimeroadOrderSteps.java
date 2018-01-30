package com.limeroadandroidautomation.scripts;

import org.testng.annotations.Test;

import com.limeroadandroidautomation.pages.AddtocartTestPage;
import com.limeroadandroidautomation.pages.BrandproductdetailsTestPage;
import com.limeroadandroidautomation.pages.ChoosecatagoryTestPage;
import com.limeroadandroidautomation.pages.LrwelcomeTestPage;
import com.limeroadandroidautomation.pages.ProductdetailsTestPage;
import com.limeroadandroidautomation.pages.SearchresultTestPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class LimeroadOrderSteps extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void LROrderFlow()
	{
		LrwelcomeTestPage wp=new LrwelcomeTestPage();
		wp.clickonShopForMenOrWomen("shop women");
		
		ChoosecatagoryTestPage choose=new ChoosecatagoryTestPage();
		choose.chooseProduct("Sarees", "₹700 - ₹1500");
		
		SearchresultTestPage search=new SearchresultTestPage();
		search.selectBrandName();

		BrandproductdetailsTestPage branddetails=new BrandproductdetailsTestPage();
		branddetails.verifyProductList();
		branddetails.clickOnFilter();
		branddetails.selectYourProductByPrice("PRICE", "₹1000 TO ₹1499");
		branddetails.clickOnApply();
		branddetails.clickOnSortBtn();
		search.productSortBy("Price: Low-High");
		branddetails.selectProduct(0);
		
		
		ProductdetailsTestPage details=new ProductdetailsTestPage();
		details.clickOnAddToCart();
		
		AddtocartTestPage addtoCart= new AddtocartTestPage();
		addtoCart.selectProceedToCart();
		addtoCart.verifyProductOnCart();
	
		
	}

}
