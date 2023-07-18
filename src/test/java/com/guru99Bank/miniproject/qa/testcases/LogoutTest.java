package com.guru99Bank.miniproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Bank.miniproject.qa.base.Base;
import com.guru99Bank.miniproject.qa.pages.LoginPage;
import com.guru99Bank.miniproject.qa.pages.ManagerHomePage;

public class LogoutTest extends Base {
	LoginPage loginPage;
	ManagerHomePage managerHomePage;

	@Test(priority = 1, description = "Verify Log out from the application.")
	public void verifyLogoutFromApplication() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		loginPage = managerHomePage.logoutFromApplication();
		Assert.assertTrue(loginPage.isAlertPresent(), "Alert message prompt is not displayed.");
		Assert.assertEquals(loginPage.getAlertText(), dataProperties.getProperty("SuccessLogoutAlertMessage"), "Text does not match | Actual: " + loginPage.getAlertText() + " | Expected: " + dataProperties.getProperty("SuccessLogoutAlertMessage"));
		loginPage.acceptAlert();
	}
}
