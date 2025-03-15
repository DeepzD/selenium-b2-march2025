package com.dd.SauceData;

import org.testng.annotations.DataProvider;

public class SauceTestData {

    @DataProvider(name="user-credentials")
    public Object[][] userCredentials(){
        return new Object[][]{
                {"","","Epic sadface: Username is required"},
                {"","password","Epic sadface: Username is required"},
                {"standard-user","","Epic sadface: Password is required"}

        };
    }
}
