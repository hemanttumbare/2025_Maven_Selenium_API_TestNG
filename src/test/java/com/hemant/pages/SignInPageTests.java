package com.hemant.pages;

import com.hemant.base.BaseDriver;
import com.hemant.hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends Hooks {


    @Test
    public void testcustomerLoginLabelIsDisplayed() {

        HomePage homePage = new HomePage(BaseDriver.getDriver());

        BaseDriver.getDriver().get("https://magento.softwaretestingboard.com/");

        SignInPage signInPage = homePage.clickOnSignInLink();

        Assert.assertTrue(signInPage.checkCustomerLoginLabel(), "customerLoginLabel does not exist...!!!");
    }


}
