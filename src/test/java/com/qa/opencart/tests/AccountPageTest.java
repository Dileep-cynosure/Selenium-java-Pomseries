package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

//@Listeners()
public class AccountPageTest extends Base {

	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}

	@Test
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageURL().contains(AppConstants.ACC_PAGE_FRACTION_URL), AppError.URL_NOT_FOUND);
	}

	@Test
	public void accPageHeadersTest() {
		List<String> accPageHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(accPageHeadersList, AppConstants.ACC_PAGE_headers, AppError.ACCPAGE_HEADERS_NOTFOUND);
	}

	@Test(dataProvider = "getSearhData")
	public void searTest(String searchKey, int resultsCount) {
		searchResultsPage = accPage.doSearch(searchKey);
		Assert.assertEquals(searchResultsPage.getSearchResultsCount(), resultsCount, AppError.RESULTS_COUNT_MISMATCHED);
	}

	@DataProvider
	public Object[][] getSearhData() {

		return new Object[][] { { "macbook", 3 }, { "imac", 1 }, { "samsung", 2 }, { "airtel", 0 } };
	}
//	
//	@Test(dataProvider = "getSearchData")
//	public void searchTest(String searchKey, int resultsCount) {
//		searchResultsPage = accPage.doSearch(searchKey);
//		
//		Assert.assertEquals(searchResultsPage.getSearchResultsCount(), resultsCount, AppError.RESULTS_COUNT_MISMATCHED);
//	}

}
