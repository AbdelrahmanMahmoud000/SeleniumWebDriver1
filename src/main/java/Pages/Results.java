package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Results {

	// Variable
	private WebDriver driver;
	
	//Locators
	private By resultStats = By.id("result-stats");
	// constructor
	public Results(WebDriver driver) {
		this.driver = driver; 

	}
	
	//Keywords
	public String getResultStats() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(resultStats));
        return  driver.findElement(resultStats).getText();
	}
}
