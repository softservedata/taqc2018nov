package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	//@Test
	public void testApp() {
		Assert.assertTrue(true);
	}

	@Test
	public void testApp1() throws Exception {
		System.out.println("surefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
		System.out.println("selenium.version = " + System.getProperty("selenium.version"));
		System.out.println("System.getenv().database.password = " + System.getenv().get("DATABASE_PASSWORD"));
	}
	
	@DataProvider(parallel = true)
	public Object[][] concurrencyData() {
		return new Object[][] {
			{ "1" },
			{ "2" },
		};
	}

	//@Test(dataProvider = "concurrencyData")
	public void checkSeleniumIDE(String s) throws InterruptedException {
		System.out.println("this.getClass().getResource(\"/chromedriver-windows-32bit.exe\").getPath() = "
				+ this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		System.setProperty("webdriver.chrome.driver",
				//"/C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1)
				);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 0 by default
		//
		driver.get("https://www.google.com/");
		Thread.sleep(1000); // Do not use
		System.out.println("Google First TITLLE: " + driver.getTitle());
		//
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		//driver.findElement(By.name("q")).sendKeys("selenium download");
		Thread.sleep(1000); // Do not use
		//
		driver.findElement(By.name("q")).sendKeys("selenium download" + Keys.ENTER);
		//driver.findElement(By.name("q")).submit();
		//
		System.out.println("Google selenium TITLLE: " + driver.getTitle());
		//
		Thread.sleep(1000); // Do not use
		System.out.println("Google Second TITLLE: " + driver.getTitle());
		//
		// Click: Downloads - Selenium
		driver.findElement(By.xpath("//a/h3[text()='Downloads - Selenium']/..")).click();
		System.out.println("Download_1 TITLLE: " + driver.getTitle());
		Thread.sleep(1000); // Do not use
		System.out.println("Download_2 TITLLE: " + driver.getTitle());
		//
		WebElement actualElement = driver.findElement(By.cssSelector("a[name='selenium_ide'] > p"));
		Assert.assertEquals(actualElement.getText(),
				"Selenium IDE is a Chrome and Firefox plugin which records and plays back user interactions with the browser. Use this to either create simple scripts or assist in exploratory testing."
				);
		Thread.sleep(4000);
		driver.quit();
		//
		System.out.println("done");
	}

	//@Test
	public void testRegres() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		Thread.sleep(1000);
		//
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		Thread.sleep(1000);
		//
		// Button Login
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertEquals("work",
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)")).getText(),
				"Error profile name");
		Thread.sleep(1000);
		//
		// Steps
		// Open Drop-Down
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(1000);
		//
		// Button Logout
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("ukraine_logo2.gif"));
		Thread.sleep(2000);
		//
		driver.quit();
	}

}
