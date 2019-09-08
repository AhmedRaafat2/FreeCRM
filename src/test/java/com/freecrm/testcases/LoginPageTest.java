package com.freecrm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ahmed\\Desktop\\seleniumJars\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://classic.crmpro.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void titleTest() {
        String expectedResult = "CRMPRO - CRM software for customer relationship management, sales, and support.";
        String acctualResult = driver.getTitle();
        System.out.println(acctualResult);
        Assert.assertEquals(acctualResult,expectedResult);
    }

    @Test(priority = 2)
    public void urlCheck() {
        String expectedResult = "https://classic.crmpro.com/";
        String acctualResult = driver.getCurrentUrl();
        System.out.println(acctualResult);
        Assert.assertEquals(acctualResult,expectedResult);
    }

    @Test(priority = 3)
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']"));
        boolean expectedResult = true;
        boolean acctualResult = logo.isDisplayed();
        System.out.println(acctualResult);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(acctualResult,expectedResult);
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void loginTest() {
        WebElement loginTextBox = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        loginTextBox.sendKeys("ARTECH");
        passwordTextBox.sendKeys("Elking2200");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean invisibleOverLappedElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
        if (invisibleOverLappedElement) {

            WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
            loginButton.click();
            //Assert.assertEquals(acctualResult,expectedResult);
        }
    }
}