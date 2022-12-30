package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleHP {
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img")
	WebElement logout;
	
	@FindBy(xpath="//*[@id=\"btnRoles\"]")
	WebElement NewRole;
	
	public void NwRol() {
		NewRole.click();
	}
	
	public void Homee() {
		Home.click();
	}

}
