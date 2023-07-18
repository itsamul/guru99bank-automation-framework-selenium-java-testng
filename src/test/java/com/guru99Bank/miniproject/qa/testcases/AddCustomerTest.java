package com.guru99Bank.miniproject.qa.testcases;

import com.guru99Bank.miniproject.qa.base.Base;
import com.guru99Bank.miniproject.qa.pages.AddCustomerPage;
import com.guru99Bank.miniproject.qa.pages.CustomerRegisteredPage;
import com.guru99Bank.miniproject.qa.pages.LoginPage;
import com.guru99Bank.miniproject.qa.pages.ManagerHomePage;
import com.guru99Bank.miniproject.qa.testdata.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends Base {
	LoginPage loginPage;
	ManagerHomePage managerHomePage;
	AddCustomerPage addCustomerPage;
	CustomerRegisteredPage customerRegisteredPage;

	@Test(priority = 1, description = "Verify after clicking on New Customer, page redirects to Add New Customer page.")
	public void verifyAddNewCustomerPage() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		addCustomerPage = managerHomePage.navigateToAddCustomerPage();
		Assert.assertTrue(addCustomerPage.isAddCustomerPageDisplayed(), addCustomerPage.getAddCustomerText() + " text not displayed.");
	}

	@Test(priority = 2, dataProvider = "AddNewCustomer", dataProviderClass = DataProviders.class, description = "Verify after creating new Customer, page redirects to details of added customer")
	public void verifyCustomerDetailsPage(String name, String gender, String dob, String Address, String City,
			String State, String pincode, String Mobile, String email, String password) {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		addCustomerPage = managerHomePage.navigateToAddCustomerPage();
		customerRegisteredPage = addCustomerPage.createNewCustomer(name, gender, dob, Address, City, State, pincode, Mobile, email, password);
		Assert.assertTrue(customerRegisteredPage.isCustomerRegisteredPageDisplayed(), customerRegisteredPage.getCustomerRegisteredText() + " text not displayed.");
		capturePageScreenshot();
	}

	@Test(priority = 3, dataProvider = "AddNewCustomer2", dataProviderClass = DataProviders.class, description = "Verify after creating new Customer, page redirects to details of added customer")
	public void verifyNewlyCreatedCustomerDetails(String name, String gender, String dob, String Address, String City, String State, String pincode, String Mobile, String email, String password) {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		addCustomerPage = managerHomePage.navigateToAddCustomerPage();
		customerRegisteredPage = addCustomerPage.createNewCustomer(name, gender, dob, Address, City, State, pincode, Mobile, email, password);
		Assert.assertTrue(customerRegisteredPage.isCustomerRegisteredPageDisplayed(), customerRegisteredPage.getCustomerRegisteredText() + " text not displayed.");
		Assert.assertTrue(name.equalsIgnoreCase(customerRegisteredPage.getCustomerName()));
		Assert.assertTrue(gender.equalsIgnoreCase(customerRegisteredPage.getCustomerGender()));
        Assert.assertTrue(dob.equalsIgnoreCase(customerRegisteredPage.getCustomerDob()));
		Assert.assertTrue(Address.equalsIgnoreCase(customerRegisteredPage.getCustomerAddress()));
		Assert.assertTrue(City.equalsIgnoreCase(customerRegisteredPage.getCustomerCity()));
		Assert.assertTrue(State.equalsIgnoreCase(customerRegisteredPage.getCustomerState()));
		Assert.assertTrue(pincode.equalsIgnoreCase(customerRegisteredPage.getCustomerPin()));
		Assert.assertTrue(Mobile.equalsIgnoreCase(customerRegisteredPage.getCustomerMobileNo()));
        Assert.assertTrue(email.equalsIgnoreCase(customerRegisteredPage.getCustomerEmail()));
	}
}
