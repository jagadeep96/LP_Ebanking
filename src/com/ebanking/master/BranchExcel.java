package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BranchExcel {

	public static void main(String[] args) throws IOException {
		//instance class	
		Library LB= new Library();
		
		LB.LaunchApp("http://103.211.39.246/ranford2/");
		LB.AdminLogin("Admin","Testing@Mq");
		
		//TO Get TestData
		FileInputStream FIS= new FileInputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\RFdata.xlsx"); 
		XSSFWorkbook WB= new XSSFWorkbook(FIS);
		XSSFSheet WS= WB.getSheet("Branch");
		
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
			XSSFCell WC4=WR.getCell(4);
			XSSFCell WC5=WR.getCell(5);
			XSSFCell WC6=WR.getCell(6);
			
			XSSFCell WC7=WR.createCell(7);
			//cell values
			//String BName, String Address, String Area, String ZipCode, String country, String state, String city
			String Bname= WC.getStringCellValue();
			String Address=WC1.getStringCellValue();
			String Area = WC2.getStringCellValue();
			String ZipCode=WC3.getStringCellValue();
			String country=WC4.getStringCellValue();
			String state=WC5.getStringCellValue();
			String city=WC6.getStringCellValue();
			
			String Res= LB.BranchCreation(Bname, Address, Area, ZipCode, country, state, city);
			System.out.println(Res);
			WC7.setCellValue(Res); //result
		}
		
		//Results
		FileOutputStream FOS= new FileOutputStream("D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\results\\RF_BranchResult.xlsx");
		WB.write(FOS);
		WB.close();
		
	}

}
