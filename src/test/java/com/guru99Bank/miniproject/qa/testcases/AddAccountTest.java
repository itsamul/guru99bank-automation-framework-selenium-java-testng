package com.guru99Bank.miniproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Bank.miniproject.qa.base.Base;
import com.guru99Bank.miniproject.qa.pages.AccountCreatedPage;
import com.guru99Bank.miniproject.qa.pages.AddAccountPage;
import com.guru99Bank.miniproject.qa.pages.LoginPage;
import com.guru99Bank.miniproject.qa.pages.ManagerHomePage;
import com.guru99Bank.miniproject.qa.testdata.DataProviders;

public class AddAccountTest extends Base {
    LoginPage loginPage;
    ManagerHomePage managerHomePage;
    AddAccountPage addAccountPage;

    AccountCreatedPage accountCreatedPage;
    @Test(priority = 1, description = "Verify after clicking on New Account, page redirects to Add New Account page.")
    public void verifyAddNewAccountPage() {
        loginPage = new LoginPage(driver);
        loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"),dataProperties.getProperty("validPassword"));
        managerHomePage = new ManagerHomePage(driver);
        addAccountPage = managerHomePage.navigateToAddAccountPage();
        Assert.assertTrue(addAccountPage.isAddAccountPageDisplayed(), addAccountPage.getAccountPageText() + " text not displayed.");
    }

    @Test(priority = 2, dataProvider = "AddNewAccount", dataProviderClass = DataProviders.class, description = "Verify after creating new Account, page redirects to details of added Account")
    public void verifyAccountDetailsPage(String customerId, String accountType, String depositAmount) {
        loginPage = new LoginPage(driver);
        loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"),dataProperties.getProperty("validPassword"));
        managerHomePage = new ManagerHomePage(driver);
        addAccountPage = managerHomePage.navigateToAddAccountPage();
        accountCreatedPage = addAccountPage.createNewAccount(customerId, accountType, depositAmount);
        Assert.assertTrue(accountCreatedPage.isAccountCreatedPageDisplayed(), accountCreatedPage.getAccountCreatedText() + " text not displayed.");
    }

    @Test(priority = 3, dataProvider = "AddNewAccount", dataProviderClass = DataProviders.class, description = "Verify the details of the newly added customer")
    public void verifyNewlyCreatedAccountDetails(String customerId, String accountType, String depositAmount) {
        loginPage = new LoginPage(driver);
        loginPage.loginToAppWithCredentials(dataProperties.getProperty("validUserId"),dataProperties.getProperty("validPassword"));
        managerHomePage = new ManagerHomePage(driver);
        addAccountPage = managerHomePage.navigateToAddAccountPage();
        accountCreatedPage = addAccountPage.createNewAccount(customerId, accountType, depositAmount);
        Assert.assertTrue(accountCreatedPage.isAccountCreatedPageDisplayed(), accountCreatedPage.getAccountCreatedText() + " text not displayed.");
        Assert.assertTrue(customerId.equalsIgnoreCase(accountCreatedPage.getCustomerId()));
        Assert.assertTrue(accountType.equalsIgnoreCase(accountCreatedPage.getCustomerAccountType()));
        Assert.assertTrue(depositAmount.equalsIgnoreCase(accountCreatedPage.getCustomerCurrentAmount()));
    }
}
