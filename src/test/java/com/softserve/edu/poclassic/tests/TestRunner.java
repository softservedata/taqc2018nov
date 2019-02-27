package com.softserve.edu.poclassic.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.poclassic.pages.LoginPage;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public abstract class TestRunner {
	private WebDriver driver;

	@Step("@Step startBrowser")
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Step("@Step exitBrowser")
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@Step("@Step GotoApplication")
	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://regres.herokuapp.com/login");
	}

    @Step("@Step CheckTestStatus")
	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
		    saveImageAttach(getFileName());
			driver.get("http://regres.herokuapp.com/logout");
		}
	}

    @Step("@Step LoadApplication")
	protected LoginPage loadApplication() {
		return new LoginPage(driver); 
	}
	
	private String getFileName() {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return "./" + currentTime + "_screenshot.png";
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] saveImageAttach(String attachName) {
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
}

