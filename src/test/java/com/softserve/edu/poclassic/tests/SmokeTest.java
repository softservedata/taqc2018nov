package com.softserve.edu.poclassic.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.poclassic.data.User;
import com.softserve.edu.poclassic.data.UserRepository;
import com.softserve.edu.poclassic.pages.LoginPage;
import com.softserve.edu.poclassic.pages.RegistratorHomePage;

public class SmokeTest extends TestRunner {

	@DataProvider//(parallel = true)
	public Object[][] validUsers() {
		return new Object[][] {
            { UserRepository.getExist() },
			};
	}

	@Test(dataProvider = "validUsers")
	public void checkLogin(User validUser) {
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
				.contains(LoginPage.NAME_IMAGE));
		//
		// Return to previous state
	}

}
