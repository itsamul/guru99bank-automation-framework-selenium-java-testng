package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    WebDriver driver;

    @FindBy(xpath="//p[@class='heading3']")
    WebElement accountGeneratedMsg;

    @FindBy(xpath="//td[normalize-space()='Account ID']")
    WebElement accountIdText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[4]/td[2]")
    WebElement accountId;

    @FindBy(xpath="//td[text()='Customer ID']")
    WebElement customerIdText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[5]/td[2]")
    WebElement customerId;

    @FindBy(xpath="//td[normalize-space()='Customer Name']")
    WebElement customerNameText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[6]/td[2]")
    WebElement customerName;

    @FindBy(xpath="//td[normalize-space()='Email']")
    WebElement customerEmailText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[7]/td[2]")
    WebElement customerEmail;

    @FindBy(xpath="//td[normalize-space()='Account Type']")
    WebElement customerAccountTypeText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[8]/td[2]")
    WebElement customerAccountType;

    @FindBy(xpath="//td[normalize-space()='Date of Opening']")
    WebElement customerDooText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[9]/td[2]")
    WebElement customerDoo;

    @FindBy(xpath="//td[normalize-space()='Current Amount']")
    WebElement customerCurrentAmtText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[10]/td[2]")
    WebElement customerCurrentAmt;


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreatedPageDisplayed(){
        return accountGeneratedMsg.isDisplayed();
    }

    public String getAccountCreatedText(){
        return accountGeneratedMsg.getText();
    }

    public boolean isAccountGeneratedPageDisplayed(){
        return accountGeneratedMsg.isDisplayed();
    }

    public String getAccountGeneratedText(){
        return accountGeneratedMsg.getText();
    }

    public String getAccountId(){
        return accountId.getText();
    }

    public String getCustomerId(){
        return customerId.getText();
    }

    public String getCustomerName(){
        return customerName.getText();
    }

    public String getCustomerEmail(){
        return customerEmail.getText();
    }

    public String getCustomerAccountType(){
        return customerAccountType.getText();
    }

    public String getCustomerDoo(){
        return customerDoo.getText();
    }

    public String getCustomerCurrentAmount(){
        return customerCurrentAmt.getText();
    }

    public ManagerHomePage clickContinue(){
        return new ManagerHomePage(driver);
    }

}
