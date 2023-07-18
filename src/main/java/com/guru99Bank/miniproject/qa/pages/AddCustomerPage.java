package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;

    @FindBy(xpath="//p[@class='heading3']")
    WebElement addCustomerText;

    @FindBy(xpath="//input[@name='name']")
    WebElement customerName;

    @FindBy(xpath="//input[@value='m']")
    WebElement custGenderMale;

    @FindBy(xpath="//input[@value='f']")
    WebElement custGenderFemale;

    @FindBy(id="dob")
    WebElement custDob;
    @FindBy(xpath="//textarea[@name='addr']")
    WebElement custAddress;

    @FindBy(xpath="//input[@name='city']")
    WebElement  custCity;

    @FindBy(xpath="//input[@name='state']")
    WebElement custState;

    @FindBy(xpath="//input[@name='pinno']")
    WebElement custPin;

    @FindBy(xpath="//input[@name='telephoneno']")
    WebElement custMobileNumber;

    @FindBy(xpath="//input[@name='emailid']")
    WebElement custEmail;

    @FindBy(xpath="//input[@name='password']")
    WebElement custPassword;

    @FindBy(xpath="//input[@name='sub']")
    WebElement btnSubmit;

    @FindBy(xpath="//input[@name='res']")
    WebElement btnReset;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isAddCustomerPageDisplayed(){
        return addCustomerText.isDisplayed();
    }

    public String getAddCustomerText(){
        return addCustomerText.getText();
    }

    public CustomerRegisteredPage createNewCustomer(String name, String gender, String dob, String address, String city, String state, String pincode, String mobile, String email, String password){
        customerName.sendKeys(name);
        if(gender.equalsIgnoreCase("male")) {
            custGenderMale.click();
        }  else if (gender.equalsIgnoreCase("female")){
            custGenderFemale.click();
        }
        custDob.sendKeys("04");
        custDob.sendKeys("11");
        custDob.sendKeys("2013");
        custAddress.sendKeys(address);
        custCity.sendKeys(city);
        custState.sendKeys(state);
        custPin.sendKeys(pincode);
        custMobileNumber.sendKeys(mobile);
        custEmail.sendKeys(email);
        custPassword.sendKeys(password);
        btnSubmit.click();
        return new CustomerRegisteredPage(driver);
    }
}
