package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSD {
	
	WebDriver driver;
	
	@Given("^user on Ranford Home Page$")
	public void user_on_Ranford_Home_Page() {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");				
	}

	@When("^user enters valid \"(.*)\" and \"(.*)\"$")
	public void user_enters_valid_username_and_password(String Un,String pwd) {
		
		driver.findElement(By.id("txtuId")).sendKeys(Un);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
	}

	@Then ("^user verifying admin Login validation$")
	public void user_verifying_admin_Login_validation() {
		
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

	@When("^user clicks on logout$")
	public void user_clicks_on_logout() {
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
	}

}
