package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
	//Variables
	private WebDriver driver;
   private String url = "https://www.google.com/";
   //Locators
 private By googlelego = By.xpath("//img[@alt='Google']");
 private By searchBox = By.name("q");


 
 // Constructor
 
public Home(WebDriver testDriver) {
	 driver = testDriver ;
	 
 }
   //Keywords/action
   public void navigate() {
	   driver.navigate().to(url);
}
   public String getTitle() {
	   return driver.getTitle();
   }
   public boolean isGoogleLogoIsDisplayed() {
	   return driver.findElement(googlelego).isDisplayed();
   }
   
   public void search(String query) {
		driver.findElement(searchBox).sendKeys(query + Keys.ENTER);
  
   }
   
}
