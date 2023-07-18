package com.guru99Bank.miniproject.qa.testcases;

import com.guru99Bank.miniproject.qa.base.Base;
import com.guru99Bank.miniproject.qa.pages.LoginPage;
import com.guru99Bank.miniproject.qa.pages.ManagerHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {
	LoginPage loginPage;
	ManagerHomePage managerHomePage;

	@Test(priority = 1, description = "Verify Login With Valid UserId And Valid Password")
	public void verifyLoginWithValidUserIdAndValidPassword() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		Assert.assertEquals(managerHomePage.getManagerHomePageTitle(), dataProperties.getProperty("managerHomePageTitle"), "Text does not match | Actual: " + managerHomePage.getManagerHomePageTitle() + " | Expected: " + dataProperties.getProperty("managerHomePageTitle"));
		Assert.assertEquals(managerHomePage.getManagerHomePageWelcomeMessage(), dataProperties.getProperty("managerHomePageWelcomeMessage"), "Text does not match | Actual: " + managerHomePage.getManagerHomePageWelcomeMessage() + " | Expected: " + dataProperties.getProperty("managerHomePageWelcomeMessage"));
		capturePageScreenshot();
	}

	@Test(priority = 2, description = "Verify after successful login, managers Id is displayed on managers home page")
	public void verifyManagersIdOnHomePage() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("validPassword"));
		managerHomePage = new ManagerHomePage(driver);
		Assert.assertEquals(managerHomePage.getManagerIdOnHomePage(), dataProperties.getProperty("managersIdText") + dataProperties.getProperty("validUserId"), "Text does not match | Actual: " + managerHomePage.getManagerIdOnHomePage() + " | Expected: " + dataProperties.getProperty("managersIdText") + dataProperties.getProperty("validUserId"));
	}

	@Test(priority = 3, description = "Verify Login With In-Valid UserId And Valid Password")
	public void verifyLoginWithInvalidUserIdAndValidPassword() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("invalidUserId"), dataProperties.getProperty("validPassword"));
		Assert.assertTrue(loginPage.isAlertPresent(), "Alert message prompt is not displayed.");
		Assert.assertEquals(loginPage.getAlertText(), dataProperties.getProperty("inValidLoginAlertMessage"), "Text does not match | Actual: " + loginPage.getAlertText() + " | Expected: " + dataProperties.getProperty("inValidLoginAlertMessage"));
	}

	@Test(priority = 4, description = "Verify Login With Valid UserId And In-Valid Password")
	public void verifyLoginWithValidUserIdAndInvalidPassword() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"), dataProperties.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.getAlertText(), dataProperties.getProperty("inValidLoginAlertMessage"), "Text does not match | Actual: " + loginPage.getAlertText() + " | Expected: " + dataProperties.getProperty("inValidLoginAlertMessage"));
	}

	@Test(priority = 5, description = "Verify Login With In-Valid UserId And In-Valid Password")
	public void verifyLoginWithInvalidUserIdAndInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToAppWithCredentials(dataProperties.getProperty("invalidUserId"), dataProperties.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.getAlertText(), dataProperties.getProperty("inValidLoginAlertMessage"), "Text does not match | Actual: " + loginPage.getAlertText() + " | Expected: " + dataProperties.getProperty("inValidLoginAlertMessage"));
	}

	@Test(priority = 6, description = "Verify Login With Blank UserId And Blank Password")
	public void verifyLoginWithBlankUserIdAndBlankPassword() {
		loginPage = new LoginPage(driver);
		loginPage.loginToAppWithOutCredentials();
		Assert.assertEquals(loginPage.getBlankUserIdErrorMessage(), dataProperties.getProperty("blankUserIdErrorMessage"), "Text does not match | Actual: " + loginPage.getBlankUserIdErrorMessage() + " | Expected: " + dataProperties.getProperty("blankUserIdErrorMessage"));
		Assert.assertEquals(loginPage.getBlankPasswordErrorMessage(), dataProperties.getProperty("blankPasswordErrorMessage"), "Text does not match | Actual: " + loginPage.getBlankPasswordErrorMessage() + " | Expected: " + dataProperties.getProperty("blankPasswordErrorMessage"));
	}
}
