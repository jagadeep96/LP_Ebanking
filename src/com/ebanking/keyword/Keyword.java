package com.ebanking.keyword;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {

	public static void main(String[] args) throws IOException, InterruptedException {
		// instance class
			Lib LB= new Lib();
			String Res= null;
			String Kpath="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\keyword\\Keyword_data.xlsx";
			String Kout="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\keyword\\Res_Keyword_data.xlsx";
			
			FileInputStream Fi= new FileInputStream(Kpath);
			//workbook
			XSSFWorkbook wb= new XSSFWorkbook(Fi);
			//sheet
			XSSFSheet ws= wb.getSheet("TestCase");
			XSSFSheet ws1= wb.getSheet("TestSteps");
			//row count
			int tcRc = ws.getLastRowNum();
			System.out.println(tcRc);
			
			int tsRc = ws1.getLastRowNum();
			System.out.println(tsRc);
			
			//test case
			for( int i=1; i<=tcRc; i++) {
				String exe=ws.getRow(i).getCell(2).getStringCellValue();
				if(exe.equalsIgnoreCase("Y"))
				{
					String tcId=ws.getRow(i).getCell(0).getStringCellValue();
					System.out.println(tcId);
					Thread.sleep(1000);
					//test Steps
					for(int j=1; j<=tsRc;j++) {
						String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
						if(tcId.equalsIgnoreCase(tsTcid)) {
							String key=ws1.getRow(j).getCell(3).getStringCellValue();
							System.out.println(key);
							switch(key)
							{
							case "Rlaunch":
								Res=LB.LaunchApp("http://103.211.39.246/ranford2/");
								break;
							case "Rlogin":
								Res=LB.AdminLogin("Admin","Testing@Mq");
								break;
							case "Rlogout":
								Res=LB.logout();
								break;
							case "Rbranch":
								Res=LB.BranchCreation("chempappet","3rd floor,above mahesh bank","vaishali nagar,chempapet","50007","INDIA","Andhra Pradesh","Hyderabad");
								break;
							case "Rrole":
								Res=LB.RoleCreation("ManagerChmptBranch","E");
								break;
							case "Remp":
								Res=LB.EmployeeCreation("jagadeepch","jagadeep96","ManagerChmptBranch","chempappet");
								break;	
							case "Rclse":
								Res=LB.ClseApp();	
								break;
							default:
								System.out.println("pass a valid keyword");
								break;
							}
							//result updation in test steps sheet
							ws1.getRow(j).createCell(4).setCellValue(Res);
							
							//result updation in test case sheet
							if(ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("pass"))
							{
								ws.getRow(i).createCell(3).setCellValue(Res);
							} 
							else{
								ws.getRow(i).createCell(3).setCellValue("fail");
							}
							
						}
						else {
							//ws1.getRow(j).createCell(4).setCellValue("BLOCKED");
						}
												
					}
					
					
				}
				else
				{
					ws.getRow(i).createCell(3).setCellValue("BLOCKED");
				}
			}
			FileOutputStream fo= new FileOutputStream(Kout);
			wb.write(fo);
			wb.close();
	}

}
