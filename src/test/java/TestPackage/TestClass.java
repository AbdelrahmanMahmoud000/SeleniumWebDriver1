package TestPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.Home;
import Pages.Results;


public class TestClass {
	private WebDriver driver;
	private Home home;
	private Results results;
	@Test(description = "Given I am on the Google Home Page , Then the page title will be 'Google'")
	public void assertThatGooglePageTitleIsCorrect() {
		String googlePageTitle = home.getTitle();
		Assert.assertEquals(googlePageTitle, "Google");
		
	}

	@Test
	public void assertThatGoogleLogoIsDisplayed() {
		boolean isGoogleLogoDisplayed = home.isGoogleLogoIsDisplayed();
		Assert.assertTrue(isGoogleLogoDisplayed);
	
	}
	
	@Test
	public void assertThatResultStatNotEmpty() {
		home.search("Selenium WebDriver");
		String text = results.getResultStats();
		Assert.assertNotEquals(text,"");
	}

	@BeforeMethod 
	public void beforeMethod_Chrom() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        
		home = new Home(driver);
		results = new Results(driver);
		home.navigate();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
