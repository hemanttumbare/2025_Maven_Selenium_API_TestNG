package com.hemant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Customer Login']")
    WebElement customerLoginLabel;

    SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public Boolean checkCustomerLoginLabel(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(customerLoginLabel));
        return customerLoginLabel.isDisplayed();

    }
}
