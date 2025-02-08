package com.hemant.pages;

import com.hemant.base.BaseDriver;
import com.hemant.hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends Hooks {


    @Test
    public void testHomePageLogoIsDisplayed(){

        HomePage homePage = new HomePage(BaseDriver.getDriver());

        BaseDriver.getDriver().get("https://magento.softwaretestingboard.com/");

        Assert.assertTrue(homePage.checkHomePageLogo(),"HomePage Logo does not exist...!!!");
    }


}
