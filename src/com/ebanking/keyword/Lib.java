package com.ebanking.keyword;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Lib {
	
	public static WebDriver driver;
	public static String ExpVal, ActVal;
	public static FileInputStream FIS;
	public static Properties PR;
	
	public String LaunchApp(String URL) throws IOException {
		
		FIS= new FileInputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repo.properties");
		PR=new Properties();
		PR.load(FIS);
		
		ExpVal= "Ranford Bank";		
		//launch Firefox
		driver= new FirefoxDriver();		
		//Maximize
		driver.manage().window().maximize();		
		//URL
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		ActVal= driver.findElement(By.xpath(PR.getProperty("Rbank"))).getText();		
		//Comparision		
		if(ExpVal.equalsIgnoreCase(ActVal)) {			
			System.out.println("Application Launched Successfully");
			return "pass";
		}
		else{
			System.out.println("Application launch failed");
			return "fail";
		}
		/*//get titlte
		String Title =driver.getTitle();
		System.out.println(" -Page Title : "+Title);*/
		 
	}
	
    public String AdminLogin(String uid,String pwd) {
    	ExpVal="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("A_uid"))).sendKeys(uid);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.id(PR.getProperty("A_pwd"))).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath(PR.getProperty("A_lgn"))).click();
		
		ActVal=driver.findElement(By.xpath(PR.getProperty("W_adm"))).getText();
		//Comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Successfull admin login");
			return "pass";
		}
		else {
			System.out.println("Admin login Failed");
			return "fail";
		}
		
		
	}

    public String BranchCreation(String BName, String Address, String Area, String ZipCode, String country, String state, String city) {

		ExpVal="Branch name already Exist";
		
		//click on branches
		driver.findElement(By.xpath(PR.getProperty("C_brnch"))).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				
		//New branch
		driver.findElement(By.id(PR.getProperty("N_brnch"))).click();				
		//branch name
		driver.findElement(By.xpath(PR.getProperty("B_name"))).sendKeys(BName);
		driver.findElement(By.xpath(PR.getProperty("B_adrs"))).sendKeys(Address);
		driver.findElement(By.xpath(PR.getProperty("B_area"))).sendKeys(Area);
		driver.findElement(By.xpath(PR.getProperty("B_zcode"))).sendKeys(ZipCode);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select country
		Select Cntry = new Select(driver.findElement(By.id(PR.getProperty("B_cntry"))));
		Cntry.selectByVisibleText(country);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select state
		new Select(driver.findElement(By.id(PR.getProperty("B_state")))).selectByValue(state);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select city
		new Select(driver.findElement(By.id(PR.getProperty("B_city")))).selectByValue(city);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Submit
		driver.findElement(By.xpath(PR.getProperty("B_sbmt"))).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		//Alert		
		ActVal=driver.switchTo().alert().getText();				
		driver.switchTo().alert().accept();
		
		//back to home
		driver.findElement(By.xpath(PR.getProperty("Hpage"))).click();				
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) { 
			System.out.println("Branch Creation status: Branch Already Exist");
			return "fail";
		}
		else {
			System.out.println("Branch Creation status: New Branch Created");
			return "pass";
		}				
		
	}
    
    public String RoleCreation(String RName,String Rtype) {

		ExpVal="Role Already Existed";
		//click Roles
		driver.findElement(By.xpath(PR.getProperty("C_roles"))).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//new Roles
		driver.findElement(By.id(PR.getProperty("N_roles"))).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Role Name
		driver.findElement(By.xpath(PR.getProperty("R_name"))).sendKeys(RName);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Role Type		
		new Select(driver.findElement(By.id(PR.getProperty("R_type")))).selectByVisibleText(Rtype);
		//Submit
		driver.findElement(By.id(PR.getProperty("R_sbmt"))).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		// Alert				
		ActVal=driver.switchTo().alert().getText();				
		driver.switchTo().alert().accept();
		
		//back to home
		driver.findElement(By.xpath(PR.getProperty("Hpage"))).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Role Creation status: Role Already Exist");
			return "fail";
		}
		else {
			System.out.println("Role Creation status: New Role Created");
			return "pass";
		}	
    	
	}
    
    public String EmployeeCreation(String EName,String Lpwd,String ERole,String Branch) {
    	
		ExpVal="Employer Already Existed...Try again";
		//click Employee
		driver.findElement(By.xpath(PR.getProperty("C_emply"))).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//click on new employee
		driver.findElement(By.xpath(PR.getProperty("N_emply"))).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Employer Name
		driver.findElement(By.xpath(PR.getProperty("E_name"))).sendKeys(EName);
		//Employer Login Password
		driver.findElement(By.id(PR.getProperty("E_lgn"))).sendKeys(Lpwd);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//Select Role
		new Select(driver.findElement(By.id(PR.getProperty("S_role")))).selectByValue(ERole);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//select Branch
		new Select(driver.findElement(By.id(PR.getProperty("S_brnch")))).selectByVisibleText(Branch);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//submit
		driver.findElement(By.xpath(PR.getProperty("E_sbmt"))).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//Alert
		ActVal=driver.switchTo().alert().getText();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		
		//back to home
		driver.findElement(By.xpath(PR.getProperty("Hpage"))).click();				
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);									
				
		//comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Employee Creation status: Employee Already Exist");
			return "fail";
		}
		else {
			System.out.println("Employee Creation status: New Employee Created");
			return "pass";
		}
						
	}
    
    public String logout() {
    	
    	ExpVal= "Ranford Bank";		
    	
    	//LogOut to login with new banker login
    	driver.findElement(By.xpath(PR.getProperty("lgout"))).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    	
    	ActVal= driver.findElement(By.xpath(PR.getProperty("Rbank"))).getText();
		//Comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("logout successful");
			return "pass";
		}
		else {
			System.out.println("logout failed");
			return "fail";
		}    
		//return ActVal;
    }
        
	public String ClseApp() {
		driver.close();
		return "pass";
	}
 
}
