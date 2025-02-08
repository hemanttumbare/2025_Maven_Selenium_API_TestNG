package com.hemant.hooks;

import com.hemant.base.BaseDriver;
import org.testng.annotations.*;

public class Hooks {

    public String browser = System.getProperty("browser","Chrome");

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Setting up browser...!!!");
        BaseDriver.setUpDriver(browser);
    }

    @AfterMethod
    public void afterMethod() {
        try {
            if (BaseDriver.getDriver() != null)
                    BaseDriver.getDriver().quit();
        } catch (Exception e) {
            System.out.println("Exception while closing Driver...!!!");
        }

    }


    @AfterTest
    public void afterTest() {

    }

    @AfterSuite
    public void afterSuite() {

    }
}
