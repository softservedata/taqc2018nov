package com.softserve.edu.selenide.pageobj.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.WebElement;

import com.softserve.edu.pofactory.data.User;

public class LogPage {
    public static final String SRC_ATTRIBUTE = "src";
    public static final String NAME_IMAGE = "ukraine_logo2.gif";

    public LogPage() {
    }

    // PageObject

    public WebElement getTitleMessage() {
        return $("div.col-md-7.col-xs-12");
    }

    public WebElement getLoginLabel() {
        return $("label[for='inputEmail']");
    }

    public WebElement getLoginInput() {
        return $("label[for='inputEmail']");
    }

    public WebElement getPasswordLabel() {
        return $("label[for='inputEmail']");
    }

    public WebElement getPasswordInput() {
    	return $("label[for='inputEmail']");
    }

    public WebElement getSignin() {
    	return $("label[for='inputEmail']");
    }

    public WebElement getLogo() {
    	return $("label[for='inputEmail']");
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
        return new LogPage(); 
    }

}
