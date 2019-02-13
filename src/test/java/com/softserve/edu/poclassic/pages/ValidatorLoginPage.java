package com.softserve.edu.poclassic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidatorLoginPage extends LoginPage {

	public static final String VALIDATOR_MESSAGE = "Неправильний логін або пароль";
	//
	private WebElement validatorMessage;
	
	public ValidatorLoginPage(WebDriver driver) {
		super(driver);
		//
		validatorMessage = driver.findElement(By.cssSelector("div[style='color: red;']"));
	}
	
	// Page Object
	
	// validatorMessage
	public WebElement getValidatorMessage() {
		return validatorMessage;
	}

	public String getValidatorMessageText() {
		return getValidatorMessage().getText().trim();
	}

	// Functional
	
	// Business Logic
}