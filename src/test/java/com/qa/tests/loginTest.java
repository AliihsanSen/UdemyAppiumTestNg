package com.qa.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.productsPage;

public class loginTest {

    loginPage loginPage;
    productsPage productsPage;
    @BeforeClass
    public void beforeClass(){}

    @Test
    public void invalidUserName()   {

        usernameTxtFld.sendKeys("invalidusername");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement errTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test" +
                "-Error message\"]/android.widget.TextView"));

        String actualErrTxt = errTxt.getAttribute("text");
        System.out.println("actual Error Text = " + actualErrTxt);
        String expectedErrTxt = "Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void invalidPassword(){

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("invalidPassword");
        loginBtn.click();

        WebElement errTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test" +
                "-Error message\"]/android.widget.TextView"));

        String actualErrTxt = errTxt.getAttribute("text");
        System.out.println("actual Error Text = " + actualErrTxt);
        String expectedErrTxt = "Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void successfulLogin(){

        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement productTitle = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-" +
                "desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));

        String actualProductTitle = productTitle.getAttribute("text");
        System.out.println("actualProductTitle = " + actualProductTitle);
        String expectedProductTitle = "PRODUCTS";
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

    @AfterClass
    public void afterClass(){}

}
