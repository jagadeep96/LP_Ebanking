package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RoleExcel {

	public static void main(String[] args) throws IOException {

		//Instance Variable
		Library LB= new Library();
		
		LB.LaunchApp("http://103.211.39.246/ranford2/");
		LB.AdminLogin("Admin","Testing@Mq");
		
		//To get TestData file path
		FileInputStream FIS= new FileInputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\RFdata.xlsx"); 
		
		//Workbook	
		XSSFWorkbook WB= new XSSFWorkbook(FIS);
		//sheet
		XSSFSheet WS= WB.getSheet("Role");
		//RowCount	
		int Rc=WS.getLastRowNum();
		System.out.println(Rc);
		
		//Multiple iterations------ Loop
		
		for (int i=1; i<=Rc; i++) {
			//Row
			XSSFRow WR=WS.getRow(i);
			//cell
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			//Cell Values
			String Rname= WC.getStringCellValue();
			String Rtype= WC1.getStringCellValue();
			
			String Res= LB.RoleCreation(Rname, Rtype);
			System.out.println(Res);
			WC2.setCellValue(Res); //Result
		}
		
		//Results stored
		FileOutputStream FOS= new FileOutputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\results\\RF_RoleResult.xlsx");
		WB.write(FOS);
		WB.close();		
	
	}

}
