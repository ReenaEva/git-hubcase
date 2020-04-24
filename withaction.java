package assementsele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class withaction {
	WebDriver driver;
  @Test
  public void findNumberOfItems() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jaya Ram\\Desktop\\REENA\\chrome for tis\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement categories = driver.findElement(By.xpath("//span[contains(text(),'Categories')]"));
		WebElement appliances = driver.findElement(By.xpath("//span[contains(text(),'Appliances')]"));

		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(categories));
		System.out.println("Categories" + categories);
		Thread.sleep(1000);
		act.moveToElement(categories).build().perform();
		categories.click();
		wait.until(ExpectedConditions.elementToBeClickable(appliances));
		Thread.sleep(2000);
		System.out.println("Applicat" + categories);
		act.moveToElement(appliances).build().perform();
		appliances.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/ul/li[1]/a/span")));
		driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		Thread.sleep(2000);
		System.out.println("finding number of items in the cart..");
		String cartNumber = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b"))
				.getText();
		System.out.println("Number of items in the cart: " + cartNumber);
  
	    }
}
