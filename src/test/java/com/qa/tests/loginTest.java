package com.qa.tests;

import io.appium.java_client.AppiumBy;
import mobile.baseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginPage;
import pages.productsPage;

import java.lang.reflect.Method;

public class loginTest extends baseTest {

    loginPage loginPage;
    productsPage productsPage;

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod(Method name) {
        loginPage = new loginPage();
        System.out.println("\n" + "***** Starting Test : " + name.getName() + " *****" + "\n");
    }
    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
    }


    @Test
    public void invalidUserName() {
        loginPage.enterUserName("invalidusername");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginBtn();

        String actualErrTxt = loginPage.getErrText();
        String expectedErrTxt = "Username and password do not match any user in this service.";
        System.out.println("actual Error Text = " + actualErrTxt + "\n" + "expected Error Text = "  + expectedErrTxt);
        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void invalidPassword() {

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("invalidPassword");
        loginPage.pressLoginBtn();

        String actualErrTxt = loginPage.getErrText();
        String expectedErrTxt = "Username and password do not match any user in this service.";
        System.out.println("actual Error Text = " + actualErrTxt + "\n" + "expected Error Text = "  + expectedErrTxt);
        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void successfulLogin() {

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        productsPage = loginPage.pressLoginBtn();

        String actualProductTitle = productsPage.getTitle();
        String expectedProductTitle = "PRODUCTS";
        System.out.println("actual Product Title = " + actualProductTitle + "\n" +
                "expected Product Title = " + expectedProductTitle);
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }
}