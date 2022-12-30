package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNg extends Base {
	
	@Test(dataProvider="Bdata")
	public void Branch(String BName, String Address, String Area, String ZipCode, String country, String state, String city) {
		LB.BranchCreation(BName, Address, Area, ZipCode, country, state, city);
	}
	
	@DataProvider
	
	public Object[][] Bdata(){
		Object[][] Obj= new Object[3][7];
		
		Obj[0][0]="Samalkot";
		Obj[0][1]="11-3-78,mainroad";
		Obj[0][2]="ismail nagar";
		Obj[0][3]="53344";
		Obj[0][4]="INDIA";
		Obj[0][5]="Andhra Pradesh";
		Obj[0][6]="Hyderabad";
		

		Obj[1][0]="uppaall";
		Obj[1][1]="10-3-73,mainroad";
		Obj[1][2]="bazar street";
		Obj[1][3]="53321";
		Obj[1][4]="INDIA";
		Obj[1][5]="Andhra Pradesh";
		Obj[1][6]="Nellore";
		

		Obj[2][0]="malakpet";
		Obj[2][1]="11-178,mainroad";
		Obj[2][2]="subanpura";
		Obj[2][3]="54422";
		Obj[2][4]="INDIA";
		Obj[2][5]="Andhra Pradesh";
		Obj[2][6]="Hyderabad";
		
		return Obj;
	}
	
}
