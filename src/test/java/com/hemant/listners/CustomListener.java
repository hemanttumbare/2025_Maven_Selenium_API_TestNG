package com.hemant.listners;

import com.hemant.base.BaseDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class CustomListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(testResult.getStatus()==ITestResult.FAILURE){
            if (BaseDriver.getDriver() != null) {
                byte[] screenshotBytes = ((TakesScreenshot) BaseDriver.getDriver() ).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Test "+testResult.getName(), new ByteArrayInputStream(screenshotBytes));
            }
        }
    }
}

