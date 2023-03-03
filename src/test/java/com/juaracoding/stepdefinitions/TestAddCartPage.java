package com.juaracoding.stepdefinitions;

import com.juaracoding.selenium.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import peges.AddCartPage;

public class TestAddCartPage {
    public static WebDriver driver;
    public AddCartPage addCartPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        addCartPage = new AddCartPage();
    }

    @Test
    public void testUrl() {
        driver.get("https://shop.demoqa.com/shop/");
        delay(1);
        //step verify
        Assert.assertEquals(addCartPage.getTxtShopTools(), "SHOP.TOOLS");

    }

    @Test
    public void testValidChoosDress(){
        addCartPage.login("Black","Large","2");
        Assert.assertEquals(addCartPage.getTxtShopTools(),"BLACK RIBBED SHORT SLEEVE LETTUCE HEM MIDI DRESS");
    }

    @Test
    public void testValidAdd(){
        addCartPage.getTxtAddCart();
        Assert.assertEquals(addCartPage.getTxtAddCart(),"CART");
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
