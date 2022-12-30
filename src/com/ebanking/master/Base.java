package com.ebanking.master;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class Base {
  
	Library LB= new Library();
	
  @BeforeTest
  public void beforeTest() {
	  LB.AdminLogin("Admin","Testing@Mq");
  }

  @AfterTest
  public void afterTest() {
	  LB.logout();
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  LB.LaunchApp("http://103.211.39.246/ranford2");
  }

  @AfterSuite
  public void afterSuite() {
	  LB.close();
  }

}
