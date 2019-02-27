package com.softserve.edu.poclassic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.poclassic.data.User;

import io.qameta.allure.Step;

public class RegistratorHomePage extends TopUnit {

	private class DropdownToggleComponent {
		
		//private WebElement changePassword;
		//private WebElement resetPassword;
		private WebElement singout;
		
		public DropdownToggleComponent() {
			singout = driver.findElement(By.xpath("//a[contains(@href,'logout')]"));
		}
		
		// Page Object
		
		// singout
		public WebElement getSingout() {
			return singout;
		}

		public String getSingoutText() {
			return getSingout().getText().trim();
		}

		public void clickSingout() {
			getSingout().click();
		}
	} 
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private WebElement profile;
	private WebElement dropdownToggle;
	//
	private DropdownToggleComponent dropdownToggleComponent;

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		//
		initElements();
	}

	private void initElements() {
		profile = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)"));
		dropdownToggle = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));
	}

	// Page Object

	// profile
	public WebElement getProfile() {
		return profile;
	}

	public String getProfileText() {
		return getProfile().getText().trim();
	}

	public void clickProfile() {
		getProfile().click();
	}

	// dropdownToggle
	public WebElement getDropdownToggle() {
		return dropdownToggle;
	}

	public void clickDropdownToggle() {
		getDropdownToggle().click();
	}

	// Functional
	private void openDropdownToggleComponent() {
		clickProfile();
		clickDropdownToggle();
		dropdownToggleComponent = new DropdownToggleComponent();
	}
	
	private void clickSignout() {
		openDropdownToggleComponent();
		dropdownToggleComponent.clickSingout();
	}

	// Business Logic
	
	@Step("@Step Logout")
	public LoginPage logout() {
		clickSignout();
		return new LoginPage(driver);
	}
}
