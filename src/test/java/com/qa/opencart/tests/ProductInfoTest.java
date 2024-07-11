package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;
import com.qa.opencart.errors.AppError;

public class ProductInfoTest extends Base {

	@BeforeClass
	public void productInfoSetup() {

		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(dataProvider="getProductData")
	public void productHeaderTest() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		String prodctHeader = productInfoPage.getProductHeader();
		Assert.assertEquals(prodctHeader, "MacBook Pro", AppError.ACCPAGE_HEADERS_NOTFOUND);
	}

	@Test(dataProvider = "getProductImgData")
	public void productImgount(String searchKey, String Product,  int imgCount) {
		searchResultsPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(Product);
		Assert.assertEquals(productInfoPage.getProductImagesCount(), imgCount, AppError.RESULTS_COUNT_MISMATCHED);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {

				{ "macbook", "MacBook Pro" }, { "imac", "iMac" }, { "samsung", "Samsung Galaxy Tab 10.1" },
				{ "canon", "Canon E0S 5D" }

		};
	}
	
	@DataProvider
	public Object[][] getProductImgData() {
		return new Object[][] {

				{ "macbook", "MacBook Pro" ,4}, { "imac", "iMac",3  }, { "samsung", "Samsung Galaxy Tab 10.1", 7 },
				{ "canon", "Canon E0S 5D",3 }

		};
	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> prodcutDeatils=productInfoPage.getProductInfoMap();
		
		System.out.println("=====product details======");
		System.out.println(prodcutDeatils);
		softAssert.assertEquals(prodcutDeatils.get("productname"), "MacBook Pro");
	softAssert.assertEquals(prodcutDeatils.get("Brand"), "Apple");
	softAssert.assertEquals(prodcutDeatils.get("Product Code"), "Product 18");
	softAssert.assertEquals(prodcutDeatils.get("Reward Points"), "800");
	softAssert.assertEquals(prodcutDeatils.get("Availability"), "In Stock");
	softAssert.assertEquals(prodcutDeatils.get("productprice"), "$2,000.0");
	softAssert.assertEquals(prodcutDeatils.get("exTaxPrice"), "$2,000.0");
	softAssert.assertAll();
}
}