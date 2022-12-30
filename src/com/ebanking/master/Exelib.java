package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws IOException {

		//Instance Class
		Library LB= new Library();
		
		String Rval=LB.LaunchApp("http://103.211.39.246/ranford2/");
		System.out.println(Rval);  //URL
					
		LB.AdminLogin("Admin","Testing@Mq");
					//String uid,String pwd
		Rval=LB.BranchCreation("chempappet","3rd floor,above mahesh bank","vaishali nagar,chempapet","50007","INDIA","Andhra Pradesh","Hyderabad");
					//String BName, String Address, 			String Area,       String ZipCode,String country, String state, String city
		System.out.println(Rval);
		Rval=LB.RoleCreation("ManagerChmptBranch","E");
					//String RName,String Rtype
		System.out.println(Rval);
		
		Rval=LB.EmployeeCreation("jagadeepch","jagadeep96","ManagerChmptBranch","chempappet");
					//String EName,String Lpwd,String ERole,String Branch
		System.out.println(Rval);
		
		LB.logout();
		
		LB.BankerLogin("chempappet","jagadeepch","jagadeep96");
					//String Branch,String UName,String pswd
		LB.close();
	}

}
