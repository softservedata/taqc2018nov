package com.softserve.edu.pofactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.pofactory.data.User;

public class LogPage {
    public static final String SRC_ATTRIBUTE = "src";
    public static final String NAME_IMAGE = "ukraine_logo2.gif";

    private WebDriver driver;
    //
    @FindBy(css = "div.col-md-7.col-xs-12")
    private WebElement titleMessage;
    //
    @FindBy(xpath = "//label[contains(@for,'inputEmail')]")
    private WebElement loginLabel;
    //
    //@CacheLookup
    @FindBy(id = "login")
    private WebElement loginInput;
    //
    @FindBy(xpath = "//label[contains(@for,'inputPassword')]")
    private WebElement passwordLabel;
    //
    @FindBy(id = "password")
    private WebElement passwordInput;
    //
    @FindBy(css = "button.btn.btn-primary")
    private WebElement signin;
    //
    @FindBy(css = "img.login_logo.col-md-8.col-xs-12")
    private WebElement logo;

    public LogPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this); // 1st item
    }

    // PageObject

    public WebElement getTitleMessage() {
        return titleMessage;
    }

    public WebElement getLoginLabel() {
        return loginLabel;
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public WebElement getPasswordLabel() {
        return passwordLabel;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSignin() {
        return signin;
    }

    public WebElement getLogo() {
        return logo;
    }

    public String getLoginLabelText() {
        return getLoginLabel().getText().trim();
    }

    public String getLoginInputText() {
        return getLoginInput().getText();
    }

    public String getPasswordLabelText() {
        return getPasswordLabel().getText().trim();
    }

    public String getPasswordInputText() {
        return getPasswordInput().getText();
    }

    public String getSignintText() {
        return getSignin().getText().trim();
    }

    public String getLogoAttributeText(String attribute) {
        return getLogo().getAttribute(attribute).trim();
    }

    public String getLogoAttributeSrcText() {
        return getLogoAttributeText(SRC_ATTRIBUTE);
    }

    public void setLoginInput(String login) {
        getLoginInput().sendKeys(login);
    }

    public void setLoginInputClear(String login) {
        clearLoginInput();
        setLoginInput(login);
    }

    public void setPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void setPasswordInputClear(String password) {
        clearPasswordInput();
        setPasswordInput(password);
    }

    public void clearLoginInput() {
        getLoginInput().clear();
    }

    public void clearPasswordInput() {
        getPasswordInput().clear();
    }

    public void clickLogin() {
        getLoginInput().click();
    }

    public void clickPassword() {
        getPasswordInput().click();
    }

    public void clickSignin() {
        getSignin().click();
    }

	// Functional

    private void setLoginData(User user) {
        setLoginInputClear(user.getLogin());
        setPasswordInputClear(user.getPassword());
        clickSignin();
    }

    // Business Logic

    public LogPage unsuccessfulLogin(User invalidUser) {
        setLoginData(invalidUser);
        return new LogPage(driver); 
    }

}
