package com.ebanking.master;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Instance Class
		Library LB= new Library();
		
		LB.LaunchApp("http://103.211.39.246/ranford2/");
		LB.AdminLogin("Admin","Testing@Mq");
		
		//TO Get TestData
		FileInputStream FIS= new FileInputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\RFdata.xlsx"); 
		XSSFWorkbook WB= new XSSFWorkbook(FIS);
		XSSFSheet WS= WB.getSheet("Employee");
		
		int Rc= WS.getLastRowNum();
		System.out.println(Rc);
		
		//for loop iterator
		for(int i=1; i<=Rc; i++) {
			//row
			XSSFRow WR= WS.getRow(i);
			//cell
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			XSSFCell WC2=WR.getCell(2);
			XSSFCell WC3=WR.getCell(3);
			
			XSSFCell WC4=WR.createCell(4);
			//Cell values
			//String EName,String Lpwd,String ERole,String Branch
			String Ename=WC.getStringCellValue();
			String Lpwd=WC1.getStringCellValue();
			String ERole=WC2.getStringCellValue();
			String Branch=WC3.getStringCellValue();
			
			String Res1=LB.EmployeeCreation(Ename, Lpwd, ERole, Branch);
			System.out.println(Res1);
			WC4.setCellValue(Res1);// RESULT			
		}
		
		//RESULTS
		FileOutputStream FOS= new FileOutputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\results\\RF_EmpResult.xlsx");
		WB.write(FOS);
		WB.close();
		
	}

}



