package com.limeroadandroidautomation.bean;

public class LRProductInfoBean {
	
	public static String beanProductName;
	public static String beanProductPrice;
	
	public static String getProductName()
	{
		return beanProductName;
		
	}
	public static String getProductPrice()
	{
		return beanProductPrice;
		
	}
	public static void setProductName(String productName)
	{
		beanProductName= productName;
		
	}
	public static void setProductPrice(String productPrice)
	{
		beanProductPrice=productPrice;
		
	}

}
