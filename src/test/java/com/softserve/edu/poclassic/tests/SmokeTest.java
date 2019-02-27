package com.softserve.edu.poclassic.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.poclassic.data.User;
import com.softserve.edu.poclassic.data.UserRepository;
import com.softserve.edu.poclassic.pages.LoginPage;
import com.softserve.edu.poclassic.pages.RegistratorHomePage;
import com.softserve.edu.poclassic.pages.ValidatorLoginPage;
import com.softserve.edu.poclassic.pages.TopUnit.ChangeLanguageFields;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("@Epic AllureTest")
@Feature("@Feature Login_Application_Test")
public class SmokeTest extends TestRunner {

	@DataProvider//(parallel = true)
	public Object[][] validUsers() {
		return new Object[][] {
            { UserRepository.getExist() },
			};
	}

    @Description("@Description class AllureTest; testRegres().")
    @Severity(SeverityLevel.NORMAL)
    @Story("@Story check_Product_Currency STORY")
	@Test(dataProvider = "validUsers")
	public void checkLogin(User validUser) {
		// Info
		// Precondition
		//
		// Steps
		RegistratorHomePage registratorHomePage = loadApplication()
				.successRegistratorLogin(validUser);
		//
		// Check
		Assert.assertEquals(registratorHomePage.getProfileText(),
				validUser.getLogin());
		//
		// Steps
		LoginPage loginPage = registratorHomePage.logout();
		//
		// Check
		Assert.assertTrue(loginPage.getLogoAttributeSrcText()
				.contains("111" + LoginPage.NAME_IMAGE));
		//
		// Return to previous state
		// Info
	}

	@DataProvider//(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
            { UserRepository.getInvalid() },
			};
	}

	//@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogin(User invalidUser) {
		// Precondition
		//
		// Steps
		ValidatorLoginPage validatorLoginPage = loadApplication()
				.unsuccessfulLogin(invalidUser);
		//
		// Check
		Assert.assertTrue(validatorLoginPage.getValidatorMessageText()
				.contains(ValidatorLoginPage.VALIDATOR_MESSAGE));
		//
		// Return to previous state
	}

	
	@DataProvider//(parallel = true)
	public Object[][] userLocalization() {
		return new Object[][] {
            { UserRepository.getExist(), ChangeLanguageFields.ENGLISH },
			};
	}

	//@Test(dataProvider = "userLocalization")
	public void checkRefresh(User validUser, ChangeLanguageFields language) {
		// Precondition
		//
		// Steps
		LoginPage loginPage = loadApplication();
		//
		//loginPage = loginPage.changeLanguage(language);
		loginPage.changeLanguage(language);
		//
		loginPage = loginPage
			.successRegistratorLogin(validUser)
			.logout();
		//
	}

}
