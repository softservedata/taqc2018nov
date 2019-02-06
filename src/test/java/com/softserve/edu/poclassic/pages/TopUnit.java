package com.softserve.edu.poclassic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class TopUnit {

	public static enum ChangeLanguageFields {
		UKRAINIAN("українська"),
		RUSSIAN("русский"),
		ENGLISH("english");
		//
		private String field;

		private ChangeLanguageFields(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return field;
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static final String CLASS_ATTRIBUTE = "class"; 
    public static final String SRC_ATTRIBUTE = "src"; 
    public static final String VALUE_ATTRIBUTE = "value"; 
    //
	protected WebDriver driver;
	//
	private WebElement titleMessage;
	private Select changeLanguage;

	public TopUnit(WebDriver driver) {
		this.driver = driver;
		//
		// titleMessage = driver.findElement(By.cssSelector("div.col-md-7.col-xs-12"));
		// changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
		initElements();
	}

	private void initElements() {
		titleMessage = driver.findElement(By.cssSelector("div.col-md-7.col-xs-12"));
		changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
	}

	// Page Object

	// titleMessage;
	public WebElement getTitleMessage() {
		return titleMessage;
	}

	public String getTitleMessageTest() {
		return getTitleMessage().getText();
	}

	// changeLanguage;
	public Select getChangeLanguage() {
		return changeLanguage;
	}

	public WebElement getChangeLanguageAsWebElement() {
		return getChangeLanguage().getWrappedElement();
	}

	public WebElement getChangeLanguageSelected() {
		return getChangeLanguage().getFirstSelectedOption();
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguageSelected().getText().trim();
	}

	public void clickChangeLanguage() {
		getChangeLanguageAsWebElement().click();
	}

	protected void setChangeLanguage(String text) {
		getChangeLanguage().selectByVisibleText(text);
	}

	// Functional

	public void selectChangeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language.toString());
	}

	// Business Logic
}
