package com.softserve.edu.selenide;

//import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

//import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;

public class LogTest {
 
    @BeforeClass
    public void setup() {
//        System.setProperty("webdriver.chrome.driver",
//        		this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
//        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
        //Configuration.timeout = 10;
        open("https://softserve.academy/");
    }
 
    @Test
    public void checkLogin() {
    	$(byText("Incoming Tests")).click();
    	$(".login a[href*='login']").click();
        $("#username").setValue("username");
        $("#password").setValue("Hello");
        //takeScreenShot("complex-form.png");
        //$("#password").shouldHave(text("Hello"));
        $("#password").shouldHave(value("Hello")); // Assert
        assertTrue($$("#paymentScheduleTable").size() == 0);
    }
 
    @AfterClass
    public void tearDown() {
        //$(".login-button__menu-icon").click();
        //$("#login__logout").shouldBe(visible).click();
    }
}
