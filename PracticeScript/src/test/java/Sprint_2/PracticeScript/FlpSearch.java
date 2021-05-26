package Sprint_2.PracticeScript;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class FlpSearch {
	@Test
	public void TestFlipkartSearch() throws InterruptedException {

		String url = "https://www.flipkart.com";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\selenium practice\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(url);

		// Checking page is navigated with the expected title
		String actual = driver.getTitle();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);

		// login
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9482871527");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("buddy@8");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(2000);

		// Check Search Box is Displayed
		WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
		Assert.assertEquals(searchbx.isDisplayed(), true);

		driver.findElement(By.xpath("//input[@name ='q']")).sendKeys("Books");
		Thread.sleep(2000);

		// Clicked on Search button
		driver.findElement(By.xpath("//button[@type='submit']//*[local-name()='svg']")).click();

		String result = driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
		System.out.println(result);

		List<WebElement> flipkartTotalItems = driver
				.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']//div//div//div//a[2][@title]"));
		for (int i = 0; i < flipkartTotalItems.size(); i++) {
			System.out.println(flipkartTotalItems.get(i).getAttribute("title"));
			System.out.println(i);
		}
		Thread.sleep(3000);
		Actions action = new Actions(driver);

		WebElement sort = driver.findElement(By.xpath("//div[normalize-space()='Price -- Low to High']"));
		sort.click();

		Select min = new Select(driver.findElement(By.xpath("//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")));
		min.selectByValue("200");
		Thread.sleep(3000);
		Select max = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")));
		max.selectByValue("1000");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@title='4★ & above']//div[@class='_24_Dny']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='English']//div[@class='_24_Dny']")).click();
		Thread.sleep(3000);

		driver.close();
	}
}
