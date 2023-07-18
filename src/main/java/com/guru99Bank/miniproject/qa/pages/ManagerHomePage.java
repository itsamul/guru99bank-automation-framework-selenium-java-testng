package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
	WebDriver driver;

	@FindBy(xpath = "//marquee[@class='heading3']")
	WebElement welcomeText;

	@FindBy(xpath = "//td[contains(text(), 'Manger Id :')]")
	WebElement managerId;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement lnkLogout;

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement lnkNewCustomer;

	@FindBy(xpath = "//a[text()='New Account']")
	WebElement lnkNewAccount;

	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isWelcomeTextPresent() {
		return welcomeText.isDisplayed();
	}

	public String getManagerHomePageWelcomeMessage() {
		return welcomeText.getText();
	}

	public String getManagerHomePageTitle() {
		return driver.getTitle();
	}

	public String getManagerIdOnHomePage() {
		return managerId.getText();
	}

	public LoginPage logoutFromApplication() {
		lnkLogout.click();
		return new LoginPage(driver);
	}

	public AddCustomerPage navigateToAddCustomerPage() {
		lnkNewCustomer.click();
		return new AddCustomerPage(driver);
	}

	public AddAccountPage navigateToAddAccountPage() {
		lnkNewAccount.click();
		return new AddAccountPage(driver);
	}

}
