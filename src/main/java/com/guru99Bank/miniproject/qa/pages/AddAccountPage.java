package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage {
	WebDriver driver;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement addAccountText;
	@FindBy(xpath = "//input[@name='cusid']")
	WebElement customerId;
	@FindBy(xpath = "//select[@name='selaccount']")
	WebElement customerAccountType;
	@FindBy(xpath = "//input[@name='inideposit']")
	WebElement initialDeposit;
	@FindBy(xpath = "//input[@name='button2']")
	WebElement btnSubmit;
	@FindBy(xpath = "//input[@name='reset']")
	WebElement btnReset;
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement btnHome;

	public AddAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAddAccountPageDisplayed() {
		return addAccountText.isDisplayed();
	}

	public String getAccountPageText() {
		return addAccountText.getText();
	}

	public AccountCreatedPage createNewAccount(String custId, String accountType, String depositAmt) {
		customerId.sendKeys(custId);
		if (accountType.equalsIgnoreCase("Savings")) {
			Select accType = new Select(customerAccountType);
			accType.selectByValue(accountType);
		} else if (accountType.equalsIgnoreCase("Current")) {
			Select accType = new Select(customerAccountType);
			accType.selectByValue(accountType);
		}
		initialDeposit.sendKeys(depositAmt);
		btnSubmit.click();
		return new AccountCreatedPage(driver);
	}
}
