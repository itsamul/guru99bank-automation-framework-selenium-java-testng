package com.guru99Bank.miniproject.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    WebDriver driver;
    @FindBy(name="uid")
    WebElement userid;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="btnLogin")
    WebElement btnLogin;

    @FindBy(id="message23")
    WebElement blankUserIdError;

    @FindBy(id="message18")
    WebElement blankPasswordError;

    @FindBy(xpath="//input[@name='btnReset']")
    WebElement btnReset;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToAppWithCredentials(String strUsername, String strPassword){
        userid.sendKeys(strUsername);
        password.sendKeys(strPassword);
        btnLogin.click();
    }

    public void loginToAppWithOutCredentials(){
        try {
            userid.sendKeys(Keys.TAB);
            password.sendKeys(Keys.TAB);
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getBlankUserIdErrorMessage(){
        return blankUserIdError.getText();
    }

    public String getBlankPasswordErrorMessage(){
        return blankPasswordError.getText();
    }

    public Alert getAlert() {
        try {
            return driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent() {
        return (getAlert( )!= null);
    }

    public String getAlertText() {
        try {
            return getAlert().getText();
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

    public void acceptAlert(){
        try {
            getAlert().accept();
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

    public void rejectAlert(){
        try {
            getAlert().dismiss();
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendTextToAlertBox(String textMessage){
        try {
            getAlert().sendKeys(textMessage);
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

}
