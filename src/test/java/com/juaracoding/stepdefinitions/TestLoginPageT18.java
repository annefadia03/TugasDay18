package com.juaracoding.stepdefinitions;

import com.juaracoding.selenium.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import peges.LoginPageT18;

public class TestLoginPageT18 {
    public static WebDriver driver;
    public LoginPageT18 loginPageT18;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPageT18 = new LoginPageT18();
    }

    @Test(priority = 1)
    public void testUrl() {
        driver.get("https://shop.demoqa.com/my-account/");
        delay(1);
        //step verify
        Assert.assertEquals(loginPageT18.getTxtLoginTitle(), "Login");
    }

    @Test(priority = 3)
    public void testValidLogin(){
        loginPageT18.login("annefadia143@gmail.com","1403Pane");
        Assert.assertEquals(loginPageT18.getTxtMyaccount(),"MY ACCOUNT");
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPageT18.login("annefadia143@gmail.com","1403Pane1");
        Assert.assertEquals(loginPageT18.getTxtErrorLostpassword(),"ERROR: The username or password you entered is incorrect. Lost your password?");
    }
    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
