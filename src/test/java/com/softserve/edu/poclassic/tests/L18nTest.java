package com.softserve.edu.poclassic.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.poclassic.pages.LoginPage;
import com.softserve.edu.poclassic.pages.LoginPage.LoginPageL10n;
import com.softserve.edu.poclassic.pages.TopUnit.ChangeLanguageFields;

public class L18nTest {
	private WebDriver driver;
	private SoftAssert softAssert;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		softAssert = new SoftAssert();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://regres.herokuapp.com/login");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			driver.get("http://regres.herokuapp.com/logout");
		}
		softAssert.assertAll();  
	}

	@DataProvider//(parallel = true)
	public Object[][] localization() {
		return new Object[][] {
            { ChangeLanguageFields.ENGLISH },
			//{ ChangeLanguageFields.RUSSIAN },
            //{ ChangeLanguageFields.UKRAINIAN },
			};
	}

	//@Test(dataProvider = "localization")
	public void checkLocalization(ChangeLanguageFields language) throws Exception {
		// Precondition
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		//
		loginPage = loginPage.changeLanguage(language);
		Thread.sleep(1000);
		//
		// Check
		System.out.println("Start Assert LOGIN_LABEL");
		Assert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		//
		System.out.println("Start Assert PASSWORD_LABEL");
		Assert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
				//LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1", "PASSWORD_LABEL_ERROR");
		//
		System.out.println("Start Assert SUBMIT_BUTTON");
		Assert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		Thread.sleep(4000);// MUST BE DELETE
		//
		// Return to previous state
		//driver.quit();
	}

	@Test(dataProvider = "localization")
	public void checkLocalizationSoftAssert(ChangeLanguageFields language) throws Exception {
		// Precondition
	    //
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		//
		loginPage = loginPage.changeLanguage(language);
		Thread.sleep(1000);
		//
		// Check
		System.out.println("Checking LOGIN_LABEL ...");
		softAssert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		//
		System.out.println("Checking PASSWORD_LABEL ...");
		softAssert.assertEquals(loginPage.getPasswordLabelText() + " Add ERROR",
				LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		        //LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1", "PASSWORD_LABEL_ERROR");
		//
		System.out.println("Checking SUBMIT_BUTTON ...");
		softAssert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		Thread.sleep(4000); // MUST BE DELETE
		//
		// Return to previous state
		//driver.quit();
		//
		softAssert.assertAll();
	}

}
