package com.hemant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath="//a[@class='logo']/img")
    WebElement homePageLogo;

    @FindBy(xpath="//div[@class='panel wrapper']/div/ul/li[2]/a")
    WebElement signInLink;

    HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean checkHomePageLogo(){
        return homePageLogo.isDisplayed();
    }

    public SignInPage clickOnSignInLink(){
          if(signInLink.isDisplayed()) {
       //     System.out.println("SignIn Link found...!!!");
            signInLink.click();
            return new SignInPage(driver);
        }else{
     //       System.out.println("SignIn Link Not found...!!!");
            return null;
        }
    }
}
