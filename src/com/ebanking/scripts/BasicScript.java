package com.ebanking.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicScript {

	public static void main(String[] args) throws InterruptedException {
 
	//launch appilication
		
		String ExpVal= "Ranford Bank";
		
		//launch Firefox
		WebDriver driver= new FirefoxDriver();		
		//Maximize
		driver.manage().window().maximize();		
		//URL
		driver.get("http://103.211.39.246/ranford2/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String ActVal= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparision
		
		if(ExpVal.equalsIgnoreCase(ActVal)) 
		{			
			System.out.println("Application Launched Successfully");
		}else
		{
			System.out.println("Application launch failed");
		}
		//get titlte
		String Title =driver.getTitle();
		System.out.println(" -Page Title : "+Title);
		
   //Admin Login
     
		ExpVal="Welcome to Admin";
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.id("txtPword")).sendKeys("Testing@Mq");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		ActVal=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		//Comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Successfull admin login");
		}
		else {
			System.out.println("Admin login Failed");
		}
			
				
  //Branch Creation
		
		ExpVal="Branch name already Exist";
		
		//click on branches
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				
		 //New branch
		driver.findElement(By.id("BtnNewBR")).click();				
		 //branch name
		driver.findElement(By.xpath("//*[@id=\"txtbName\"]")).sendKeys("chempapet");
		driver.findElement(By.xpath("//*[@id=\"txtAdd1\"]")).sendKeys("3rd floor,above mahesh bank");
		driver.findElement(By.xpath("//*[@id=\"txtArea\"]")).sendKeys("vaishali nagar,chempapet");
		driver.findElement(By.xpath("//*[@id=\"txtZip\"]")).sendKeys("500079");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select country
		Select Cntry = new Select(driver.findElement(By.id("lst_counrtyU")));
		Cntry.selectByVisibleText("INDIA");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select state
		new Select(driver.findElement(By.id("lst_stateI"))).selectByValue("Andhra Pradesh");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select city
		new Select(driver.findElement(By.id("lst_cityI"))).selectByValue("Hyderabad");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Submit
		driver.findElement(By.xpath("//*[@id=\"btn_insert\"]")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		//Alert
		
		ActVal=driver.switchTo().alert().getText();				
		driver.switchTo().alert().accept();
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) { 
			System.out.println("Branch Creation status: Branch Already Exist");
		}
		else {
			System.out.println("Branch Creation status: New Branch Created");
		}
		
		//back to home
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		
 //Role Creation
		
		ExpVal="Role Already Existed";
		//click Roles
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//new Roles
		driver.findElement(By.id("btnRoles")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Role Name
		driver.findElement(By.xpath("//*[@id=\"txtRname\"]")).sendKeys("ManagerCmptBranch");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Role Type		
		new Select(driver.findElement(By.id("lstRtypeN"))).selectByVisibleText("E");
		//Submit
		driver.findElement(By.id("btninsert")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		// Alert		
		
		ActVal=driver.switchTo().alert().getText();				
		driver.switchTo().alert().accept();
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Role Creation status: Role Already Exist");
		}
		else {
			System.out.println("Role Creation status: New Role Created");
		}
			
		//back to home
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
						
 //Employee Creation
		
		ExpVal="Employer Already Existed...Try again";
		//click Employee
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//click on new employee
		driver.findElement(By.xpath("//*[@id=\"BtnNew\"]")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Employer Name
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("jagadeep");
		//Employer Login Password
		driver.findElement(By.id("txtLpwd")).sendKeys("jagadeep96");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Select Role
		new Select(driver.findElement(By.id("lst_Roles"))).selectByValue("ManagerCmptBranch");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select Branch
		new Select(driver.findElement(By.id("lst_Branch"))).selectByVisibleText("chempapet");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//submit
		driver.findElement(By.xpath("//*[@id=\"BtnSubmit\"]")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//Alert
		ActVal=driver.switchTo().alert().getText();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Employee Creation status: Employee Already Exist");
		}
		else {
			System.out.println("Employee Creation status: New Employee Created");
		}
		
						
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	//LogOut
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		
  //Banker login
		ExpVal="Welcome to chempapet Branch";
		//select Branch Name
		new Select(driver.findElement(By.xpath("//*[@id=\"drlist\"]"))).selectByValue("chempapet");
		//User name
		driver.findElement(By.id("txtuId")).sendKeys("jagadeep");
		//password
		driver.findElement(By.id("txtPword")).sendKeys("jagadeep96");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//login
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

		
		ActVal=driver.findElement(By.xpath("//*[@id=\"Label1\"]")).getText();
		
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Successfuly completed banker login, "+ActVal);
		}
		else {
			System.out.println("banker login is Failed");
		}
	
	}

}
