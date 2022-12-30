package com.ebanking.master;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom {
	
	WebDriver driver;
	@BeforeTest
	public void pom () throws InterruptedException {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2/");
		
		//Login
		RanfordHP RHP=PageFactory.initElements(driver, RanfordHP.class);
			String ExpVal="Welcome to Admin";
		RHP.login();
			String ActVal=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
			//Comparision
			if(ExpVal.equalsIgnoreCase(ActVal)) {
				System.out.println("Successfull admin login");
			}
			else {
				System.out.println("Admin login Failed");
			}
	}		
	@Test(dataProvider="Rdata")
	public void RoleCr(String Rnam, String Rtyp) throws InterruptedException, IOException {
		
		
			//Role
			AdminHP AHP=PageFactory.initElements(driver, AdminHP.class);
			AHP.Role();
		
			//NewRole
			RoleHP NRHP=PageFactory.initElements(driver, RoleHP.class);
			NRHP.NwRol();
		
			//RoleDetails
			RolDetailHP RD=PageFactory.initElements(driver, RolDetailHP.class);
			RD.Rdetails(Rnam, Rtyp);
		   	Thread.sleep(3000);
			//alert
		//String ActVal=driver.switchTo().alert().getText();				
			driver.switchTo().alert().accept();
		/*	//comparision
			if(ExpVal.equalsIgnoreCase(ActVal)) {
				System.out.println("Role Creation status: Role Already Exist");
			}
			else {
			System.out.println("Role Creation status: New Role Created");
			}*/
			//home
			RoleHP NRH=PageFactory.initElements(driver, RoleHP.class);
			NRH.Homee();
						
	}
	
	@DataProvider
	public Object [][] Rdata(){
		Object [][] Obj= new Object [3][2];
		
		Obj[0][0]="Clerkdss";
		Obj[0][1]="E";
		
		Obj[1][0]="Managerdss";
		Obj[1][1]="E";
		
		Obj[2][0]="Cashierdss";
		Obj[2][1]="E";
		
		return Obj;
		
	}

}