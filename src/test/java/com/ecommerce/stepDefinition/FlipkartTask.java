package com.ecommerce.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTask {
	
	 
	static WebDriver driver;
	 static long  start;
	@BeforeClass
	
     private static void window() {
	
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       String url ="https://www.flipkart.com/";
       driver.get(url);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	
	@AfterClass
	
	  public static void close() {
		
             driver.quit();
	}
	
	 @BeforeMethod
	 
	   public void Start() {
		
           start = System.currentTimeMillis();
	}
	 
	 
	 @AfterMethod
	 
	 public  void end() {
		
           long end = System.currentTimeMillis();
           long tt = end - start ;
           System.out.println("TimeTaken : "+tt);
	}
	 
	 @Test (priority=1)
	 
	   public  void login() {
	
		 WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
		   button.click();
	}
	 
	 @Test(priority=2)
	 
	 public  void choose() {
		
		 WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
         text.sendKeys("MiMobiles",Keys.ENTER);
	}
	 
	 @Test(priority=3)
	 
	   public  void select() {
		
		 WebElement pic = driver.findElement(By.xpath("//div[text()='Xiaomi 11i Hypercharge 5G (Pacific Pearl, 128 GB)']"));
         pic.click();
	}
	 
	 @Test(priority=4)
	 
	      public  void windowsHandling() {
			
		 String pwind = driver.getWindowHandle();
         Set<String> allwin = driver.getWindowHandles();
         for (String x : allwin) {
			if (!x.equals(pwind)) {
				driver.switchTo().window(x);
			}
		}
		}
	 
	 @Test(priority=5) 
	 
	 public  void addToCart() {
			
         WebElement cart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
         cart.click();
}
	 
	 @Test(priority=6,enabled=true)
	 
	  public  void screenShot() throws IOException {
			
         TakesScreenshot tk = (TakesScreenshot)driver;
         File src = tk.getScreenshotAs(OutputType.FILE);
         File tgt = new File("C:\\Users\\FR\\eclipse-workspace\\JavaHome\\target\\cart.png");
         FileUtils.copyFile(src,tgt);
	}
	 
	
}
