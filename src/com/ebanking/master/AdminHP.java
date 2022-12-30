package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP {

	
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[1]/td/div/div/div")
	WebElement Branches;
	
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	WebElement Roles;
	
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
	WebElement Employee;
	
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[6]/td/a/img")
	WebElement Users;
	
	public void Branch() {
		Branches.click();
	}
	
	public void Role() {
		Roles.click();
	}
	
	public void Employee() {
		Employee.click();
	}
	
	public void User() {
		Users.click();
	}
}
