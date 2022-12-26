package com.ecommerce.stepDefinition;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTask {

	
    static WebDriver driver;
    static long start;
@BeforeClass

public static  void window() {
	
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     String url = "https://www.Amazon.com/";
     driver.get(url);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);         
}

@AfterClass

public static  void close() {
	
  driver.quit();
  
}

@BeforeMethod

public  void startTime() {
	  
	 start = System.currentTimeMillis();
}

@AfterMethod

public  void endTime() {
	
 long end = System.currentTimeMillis();
 long tt =end-start;
 System.out.println("TimeKaken :"+tt);        
}

@Test(priority=1)

public  void search() {
	
    WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
    text.sendKeys("MiMobiles",Keys.ENTER);
}


}
