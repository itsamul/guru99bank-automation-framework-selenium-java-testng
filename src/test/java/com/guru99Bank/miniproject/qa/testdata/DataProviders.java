package com.guru99Bank.miniproject.qa.testdata;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "AddNewCustomer")
    public Object[][] AddNewCustomerTestData() {
        return new Object[][] {
                {"Virendra", "male", "2013-04-11", "Jamnagar", "Jamnagar", "Gujarat", "567321", "8000439024", "Virendra17@gmail.com", "XfEs12*"},
        };
    }

    @DataProvider(name = "AddNewCustomer2")
    public Object[][] AddNewCustomer2TestData() {
        return new Object[][] {
                {"Virendra", "male", "2013-04-11", "Jamnagar", "Jamnagar", "Gujarat", "567321", "8000439024", "Virendra18@gmail.com", "XfEs12*"},
        };
    }

    
    @DataProvider(name = "AddNewAccount")
    public Object[][] AddNewAccountTestData() {
        return new Object[][] {
                {"31478", "Savings","1000"},
        };
    }
}