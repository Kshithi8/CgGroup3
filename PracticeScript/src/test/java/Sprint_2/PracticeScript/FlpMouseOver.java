package Sprint_2.PracticeScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlpMouseOver {
	WebDriver driver;
	@BeforeMethod
    public void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\selenium_practice\\selenium-java-3.141.59\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
      //div[contains(text(),'Fashion')]
      //a[normalize-space()= \"Men's Top Wear\"]
      //img[@alt='Fashion']
      //a[normalize-space()= \”Men’s Blazer\”]
   
    }
		  @Test
		   public void MouseIverSelect() throws InterruptedException {
		        	driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9482871527");

		            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("buddy@8");
		            driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		            Thread.sleep(2000);
				        Actions actions = new Actions(driver);
				        WebElement menu = driver.findElement(By.xpath("//img[@alt='Fashion']"));
				        actions.moveToElement(menu).build().perform();
				       
				        
				        WebElement subMenuOption = driver.findElement(By.xpath("//a[normalize-space()= \"Men's Top Wear\"]"));
				 
						  actions.moveToElement(subMenuOption).build().perform();
						  //  Thread.sleep(2000);
				     //  WebElement menu = driver.findElement(By.xpath("//img[@alt='Beauty, Toys & More']"));
				    
				     //  actions.moveToElement(menu).build().perform();
				        Thread.sleep(2000);
				        
				        WebElement selectMenuOption = driver.findElement(By.xpath("//a[normalize-space()= \"Men's Blazers\"]"));
						  selectMenuOption.click();
				    
				   //  WebElement subMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Safety & Hygiene Essentials')]")); 
				  //  actions.moveToElement(subMenuOption).build().perform();
				  //  Thread.sleep(2000);
				    
				  //   WebElement selectMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Sanitizers')]"));
				   //  selectMenuOption.click();
				   // Thread.sleep(2000);
				  //  driver.findElement(By.xpath("//img[@alt='DETTOL Instant Hand Sanitizer Bottle']")).click();
				  //  Thread.sleep(6000);
				  
						//div[@class='_3879cV'][normalize-space()='Raymond']
		    }
}
