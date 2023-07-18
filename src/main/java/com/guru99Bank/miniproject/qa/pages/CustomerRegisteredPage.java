package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisteredPage {
	WebDriver driver;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement customerRegisteredMsg;

	@FindBy(xpath = "//td[text()='Customer ID']")
	WebElement customerIdText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[4]/td[2]")
	WebElement customerId;

	@FindBy(xpath = "//td[text()='Customer Name']")
	WebElement customerNameText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[5]/td[2]")
	WebElement customerName;

	@FindBy(xpath = "//td[normalize-space()='Gender']")
	WebElement customerGenderText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[6]/td[2]")
	WebElement customerGender;

	@FindBy(xpath = "//td[normalize-space()='Birthdate']")
	WebElement customerDOBText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[7]/td[2]")
	WebElement customerDOB;

	@FindBy(xpath = "//td[normalize-space()='Address']")
	WebElement customerAddressText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[8]/td[2]")
	WebElement customerAddress;

	@FindBy(xpath = "//td[normalize-space()='City']")
	WebElement customerCityText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[9]/td[2]")
	WebElement customerCity;

	@FindBy(xpath = "//td[normalize-space()='State']")
	WebElement customerStateText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[10]/td[2]")
	WebElement customerState;

	@FindBy(xpath = "//td[normalize-space()='Pin']")
	WebElement customerPinText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[11]/td[2]")
	WebElement customerPin;

	@FindBy(xpath = "//td[normalize-space()='Mobile No.']")
	WebElement customerMobileText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[12]/td[2]")
	WebElement customerMobile;

	@FindBy(xpath = "//td[normalize-space()='Email']")
	WebElement customerEmailText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[13]/td[2]")
	WebElement customerEmail;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;

	public CustomerRegisteredPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCustomerRegisteredPageDisplayed() {
		return customerRegisteredMsg.isDisplayed();
	}

	public String getCustomerRegisteredText() {
		return customerRegisteredMsg.getText();
	}

	public ManagerHomePage clickContinue() {
		return new ManagerHomePage(driver);
	}

	public String getCustomerId() {
		return customerId.getText();
	}

	public String getCustomerName() {
		return customerName.getText();
	}

	public String getCustomerDob() {
		return customerDOB.getText();
	}

	public String getCustomerGender() {
		return customerGender.getText();
	}

	public String getCustomerAddress() {
		return customerAddress.getText();
	}

	public String getCustomerCity() {
		return customerCity.getText();
	}

	public String getCustomerState() {
		return customerState.getText();
	}

	public String getCustomerPin() {
		return customerPin.getText();
	}

	public String getCustomerMobileNo() {
		return customerMobile.getText();
	}

	public String getCustomerEmail() {
		return customerEmail.getText();
	}

}
