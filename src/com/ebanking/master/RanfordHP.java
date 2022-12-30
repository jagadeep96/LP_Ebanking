package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHP {
	
	//ElementProperties
	
	@FindBy(id="txtuId")
	WebElement Uname;
	
	@FindBy(id="txtPword")
	WebElement pswd;
	
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement lgn;
	
	//ElementMethod
	
	public void login() throws InterruptedException {
		Uname.sendKeys("Admin");
		pswd.sendKeys("Testing@Mq");
		Thread.sleep(3000);
		lgn.click();
	}

}
