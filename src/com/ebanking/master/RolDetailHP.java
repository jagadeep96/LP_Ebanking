package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RolDetailHP {
	
	@FindBy(xpath="//*[@id=\"txtRname\"]")
	WebElement Rname;
	
	@FindBy(xpath="//*[@id=\"lstRtypeN\"]")
	WebElement Rtype;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement Submit;
		
	
	//WebDriver driver;
	public String Rdetails(String Rn, String Rt) throws InterruptedException {
		Rname.sendKeys(Rn);
		Thread.sleep(3000);
		Select RT= new Select(Rtype);
		RT.selectByVisibleText(Rt);
		Thread.sleep(3000);
		Submit.click();	
		return Rn ;
	}	
}
