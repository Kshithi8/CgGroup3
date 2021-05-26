package Sprint_2.PracticeScript;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFlpkart {
		WebDriver driver;
	    @BeforeMethod
	    public void setUpBrowser() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\selenium_practice\\selenium-java-3.141.59\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://www.flipkart.com/");
	        driver.manage().window().maximize();
	        
	    }
	    
	    @Test
	    public void LoginWithValidCredentials() throws Exception {
	        driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9482871527");

	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("buddy@8");
	        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	        
	        List<WebElement> flipkartHomeLinks =driver.findElements(By.tagName("img"));
			List<WebElement> activehomelinks = new ArrayList<WebElement>();
	        for(int i=0;i<flipkartHomeLinks.size();i++) {
	        	if(flipkartHomeLinks.get(i).getAttribute("href")!=null) {
	        		activehomelinks.add(flipkartHomeLinks.get(i));
	        		System.out.println(flipkartHomeLinks.get(i));
	        	}
	        }
	        for(int j=0;j<activehomelinks.size();j++) {
	        	HttpURLConnection con=(HttpURLConnection) new URL(activehomelinks.get(j).getAttribute("href")).openConnection();
	        	con.connect();
	        	String response= con.getResponseMessage();
	        	System.out.println(activehomelinks.get(j).getAttribute("src")+"---->"+response);
	        	}
	    }
	    

	@AfterMethod
	    public void closeBrowser()
	    {
	        driver.close();
	    }
	}


