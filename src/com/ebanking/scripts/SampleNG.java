package com.ebanking.scripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNG {
	
	WebDriver driver;
	@BeforeTest
	public void xyz() {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	public void abc() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("http://103.211.39.246/ranford2");
	}
	
	@Test(priority=1)
	public void bcd() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.facebook.com/login");		
	}
	
	@AfterTest
	public void pqr() throws InterruptedException {
		Thread.sleep(3000);
		driver.close(); 		
	}
	
}
