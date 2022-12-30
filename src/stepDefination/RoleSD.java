package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleSD {
	
WebDriver driver;
	
	@Given("^user already on Ranford Home Page$")
	public void user_already_on_Ranford_Home_Page() {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");				
	}
	
	@When("^usser enters valid username and password")
	public void usser_enters_valid_username_and_password() {
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Testing@Mq");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
	}

	@Then("^user Veriffying Admin Login validation$")
	public void user_Veriffying_Admin_Login_validation() {
		String ExpVal="Welcome to Admin";
		String ActVal=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		//Comparision
		if(ExpVal.equalsIgnoreCase(ActVal)) {
			System.out.println("Successfull admin login");
		}
		else {
			System.out.println("Admin login Failed");
		}

	}
	
	@When("^user Click on Role button$")
	public void user_Click_on_Role_button() {
		//click Roles
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
	}
	
	@When("^user Click on New Role and Enters \"(.*)\" and \"(.*)\"$")
	public void user_Click_on_New_Role_and_Enters_and(String Rname,String Rtyp) {
			//new Roles
				driver.findElement(By.id("btnRoles")).click();
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			//Role Name
				driver.findElement(By.xpath("//*[@id=\"txtRname\"]")).sendKeys(Rname);
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			//Role Type		
				Select Rtype=new Select(driver.findElement(By.id("lstRtypeN")));
				Rtype.selectByVisibleText(Rtyp);
			//Submit
				driver.findElement(By.id("btninsert")).click();
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			//alert
				driver.switchTo().alert().accept();
	}
	@Then("^user close the Application$")
	public void user_close_the_Application(){
		driver.close();
	}
	
}
