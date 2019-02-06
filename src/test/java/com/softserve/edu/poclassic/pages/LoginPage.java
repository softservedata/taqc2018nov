package com.softserve.edu.poclassic.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.poclassic.data.User;

public class LoginPage extends TopUnit {

	public static enum LoginPageL10n {
		LOGIN_LABEL("Логін", "Логин", "Login"),
		PASSWORD_LABEL("Пароль", "Пароль", "Password"),
		SUBMIT_BUTTON("Увійти", "Войти", "Sign in");

		private HashMap<ChangeLanguageFields, String> field;

		private LoginPageL10n(String... localization) {
			field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return field.get(language).trim();
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	private static final String LOGIN_LABEL_XPATH = "//label[contains(@for,'inputEmail')]";
	private static final String LOGIN_INPUT_ID = "login";
	private static final String PASSWORD_LABEL_XPATH = "//label[contains(@for,'inputPassword')]";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String SIGNIN_CSSSELECTOR = "button.btn.btn-primary";
	private static final String LOGO_CSSSELECTOR = "img.login_logo.col-md-8.col-xs-12";

	private WebElement loginLabel;
	private WebElement loginInput;
	private WebElement passwordLabel;
	private WebElement passwordInput;
	private WebElement signin;
	private WebElement logo;

	public LoginPage(WebDriver driver) {
		super(driver);
		//
		initElements();
	}

	private void initElements() {
		loginLabel = driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
		loginInput = driver.findElement(By.id(LOGIN_INPUT_ID));
		passwordLabel = driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
		passwordInput = driver.findElement(By.id(PASSWORD_INPUT_ID));
		signin = driver.findElement(By.cssSelector(SIGNIN_CSSSELECTOR));
		logo = driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
	}

	// Page Object

	// loginLabel
	public WebElement getLoginLabel() {
		return loginLabel;
	}

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	// loginInput
	public WebElement getLoginInput() {
		return loginInput;
	}

	public String getLoginInputAttributeText(String attribute) {
		return getLoginInput().getAttribute(attribute);
	}

	public String getLoginInputText() {
		return getLoginInputAttributeText(VALUE_ATTRIBUTE);
	}

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clickLoginInput() {
		getLoginInput().click();
	}

	// passwordLabel
	public WebElement getPasswordLabel() {
		return passwordLabel;
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	// passwordInput
	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public String getPasswordInputAttributeText(String attribute) {
		return getPasswordInput().getAttribute(attribute);
	}

	public String getPasswordInputText() {
		return getPasswordInputAttributeText(VALUE_ATTRIBUTE);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickPasswordInput() {
		getPasswordInput().click();
	}

	// signin
	public WebElement getSignin() {
		return signin;
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}

	public void clickSignin() {
		getSignin().click();
	}

	// logo
	public WebElement getLogo() {
		return logo;
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}
	
	// Functional
	
	private void setLoginData(User user) {
		setLoginInputClear(user.getLogin());
		setPasswordInputClear(user.getPassword());
		clickSignin();
	}
	
	// Business Logic
	
	public LoginPage changeLanguage(ChangeLanguageFields language) {
		selectChangeLanguage(language);
		return new LoginPage(driver);
	}
	
	public LoginPage unsuccessfulLogin(User invalidUser) {
        setLoginData(invalidUser);
        return new LoginPage(driver); 
    }

//	public AdminHomePage successAdminLogin(User admin) {
//		setLoginData(admin);
//		return new AdminHomePage();
//	}

	public RegistratorHomePage successRegistratorLogin(User registrator) {
		setLoginData(registrator);
		return new RegistratorHomePage(driver);
	}
	
}
