package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AjaxTest {

	@Test
	public void AjaxIframePage() throws Exception {
	    System.setProperty("webdriver.chrome.driver",
	    		this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/");
        Thread.sleep(2000); // Do no use
	    //
		// Move to Element by JavaScript Injection
	    WebElement position = driver.findElement(By.id("using-paging-with-other-data-processing-plugins"));
	    //WebElement position = driver.findElement(By.cssSelector("#using-paging-with-other-data-processing-plugins"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", position);
		//
		//IWebElement position = driver.FindElement(By.CssSelector("#using-paging-with-other-data-processing-plugins"));
		//javaScript.ExecuteScript("arguments[0].scrollIntoView(true);", position);
		//
	    // Move to Element by Action
		//Actions action = new Actions(driver);
		//action.moveToElement(position).perform();
        Thread.sleep(2000); // Do no use
        //
        // Switch To IFrame
        driver.switchTo().frame(driver
        		.findElement(By.xpath("//div[@id='grid-paging-remote-paging-demo-pane-preview']//iframe")));
        // Switch To IFrame
        //driver.SwitchTo().Frame(driver.FindElement(By.XPath("//div[@id='grid-paging-remote-paging-demo-pane-preview']//iframe")));
        //
        // Search First Element
        WebElement tdNevadaFirstData = driver
        		.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        System.out.println("tdNevadaFirstData.getText() = " + tdNevadaFirstData.getText());
        String removeText = driver.findElement(By
        		.xpath("//td[text()='Nevada']/preceding-sibling::td[3]")).getText();
        System.out.println("removeText = " + removeText);
        //IWebElement tdNevadaFirstData = driver.FindElement(By.XPath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        //string firstDate = tdNevadaFirstData.Text;
        //Console.WriteLine("1. tdNevadaFirstData = " + tdNevadaFirstData.Text);
        //
        // Goto to Page 2
        driver.findElement(By.xpath("//span[text()='2']/..")).click();
        //Thread.sleep(4000); // Do no use
        //
        // Explicit Wait
		//Thread.sleep(2000); // DO NOT USE
        //
        // Turn off Implicit Wait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //
        //(new WebDriverWait(driver, 10)).until(
        //		ExpectedConditions.stalenessOf(tdNevadaFirstData));
//-        (new WebDriverWait(driver, 10)).until(
//-        		ExpectedConditions.invisibilityOfElementLocated(
//-        				By.xpath("//td[text()='" + tdNevadaFirstData.getText() + "']")));
        (new WebDriverWait(driver, 10)).until(
        		ExpectedConditions.invisibilityOfElementLocated(
        				By.xpath("//td[text()='" + removeText + "']")));
        //
        // Turn on Implicit Wait
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
        // Search First Element
        WebElement tdNevadaSecondData = driver
        		.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        System.out.println("tdNevadaSecondData.getText() = " + tdNevadaSecondData.getText());
        //
//		Thread.sleep(4000); // DO NOT USE
//		driver.quit();
	}

	//@Test // Verify Web Elements
	public void searchWebElements() throws Exception {
	    System.setProperty("webdriver.chrome.driver",
	    		this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
	    WebDriver driver = new ChromeDriver();
	    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		//
		//System.setProperty("webdriver.gecko.driver",
		//		"C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//
		driver.get("http://regres.herokuapp.com/login");
		//driver.get("https://www.google.com");
		Thread.sleep(1000); // DO NOT USE
		//
		// Search WebElements
		//WebElement login = driver.findElement(By.id("login")); // By implicit
//		WebElement login = (new WebDriverWait(driver, 10)).until(
//				ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		//WebElement login = (new WebDriverWait(driver, 10)).until(
		//		ExpectedConditions.presenceOfElementLocated(By.id("login")));
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement login = (WebElement) js.executeScript("return document.getElementsByName('login')[0];");
		//
		login.click();
		login.clear();
		login.sendKeys("Hello");
		//
		// Run Alert, Switch to Alert.
//		js.executeScript("alert('Hello!');");
//		Thread.sleep(4000); // DO NOT USE
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		//
		// Resize Window (not working chrome)
		//js.executeScript("window.resizeTo(512, 384);");
		//
		// Move to element
//		driver.findElement(By.name("q")).click();
//		driver.findElement(By.name("q")).clear();
//		driver.findElement(By.name("q")).sendKeys("selenium ide download" + Keys.ENTER);
//		Thread.sleep(2000); // DO NOT USE
		// Use Selenium
		//WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]")); // For
		// Localization en.
//		WebElement next = driver.findElement(By.xpath("//a[contains(text(),'10')]"));
//		Actions action = new Actions(driver);
//		action.moveToElement(next).perform();
		//
		// Use JavaScript Injection
//		js.executeScript("arguments[0].scrollIntoView(true);", next);
		//
		//Thread.sleep(4000); // DO NOT USE
		//
		// Take Screenshot
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("./screenshot.png"));
		//
		// Save html code.
//		PrintWriter w = new PrintWriter(new File("./screenshot.txt"));
//		w.print(driver.getPageSource());
//		w.flush();
//		w.close();
		//
//		Thread.sleep(4000); // DO NOT USE
//		driver.quit();
	}

}