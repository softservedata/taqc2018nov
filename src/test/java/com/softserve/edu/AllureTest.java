package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

//@Listeners({ TestListener.class })
@Epic("@Epic AllureTest")
@Feature("@Feature Login_Application_Test")
public class AllureTest {
    private WebDriver driver;

    public String getFileName() {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return "./" + currentTime + "_screenshot.png";
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveImageAttach(String attachName) {
        byte[] result = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            result = Files.readAllBytes(scrFile.toPath());
        } catch (IOException e) {
            // TODO Create Custom Exception 
            e.printStackTrace();
        }
        return result;
    }
    
    @Step("@Step startBrowse")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("@Step gotoApplication")
    public void gotoApplication() {
        driver.get("http://regres.herokuapp.com/login");
    }

    @Step("@Step typeLogin")
    public void typeLogin() {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("work");
    }

    @Step("@Step typePassword")
    public void typePassword() {
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("qwerty");
    }

    @Step("@Step clickLoginButton")
    public void clickLoginButton() {
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    @Step("@Step logout")
    public void logout() {
        // Open Drop-Down
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
        // Button Logout
        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
    }

    @Step("@Step exitBrowser")
    @AfterClass(alwaysRun = true)
    public void exitBrowser() {
        driver.quit();
    }

    @Description("@Description class AllureTest; testRegres().")
    @Severity(SeverityLevel.NORMAL)
    @Story("@Story check_Product_Currency STORY")
    @Test
    public void testRegres() throws Exception {
        startBrowser();
        Thread.sleep(1000); // For Presentation Only
        //
        gotoApplication();
        Thread.sleep(1000); // For Presentation Only
        //
        typeLogin();
        Thread.sleep(1000); // For Presentation Only
        //
        typePassword();
        Thread.sleep(1000); // For Presentation Only
        //
        clickLoginButton();
        Thread.sleep(1000); // For Presentation Only
        //
        Assert.assertEquals("work",
                driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)")).getText(),
                "Error profile name");
        Thread.sleep(1000); // For Presentation Only
        //
        logout();
        Thread.sleep(1000); // For Presentation Only
        //
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("ukraine_logo2.gif"));
        Thread.sleep(1000); // For Presentation Only
        //
        //exitBrowser();
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            saveImageAttach(getFileName());
            driver.get("http://regres.herokuapp.com/logout");
        }
    }
}
