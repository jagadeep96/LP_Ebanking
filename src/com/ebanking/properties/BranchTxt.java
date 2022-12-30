package com.ebanking.properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ebanking.master.Library;

public class BranchTxt {

	public static void main(String[] args) throws IOException {
		//instance class
		Library LB= new Library();
		
		LB.LaunchApp("http://103.211.39.246/ranford2/");
		LB.AdminLogin("Admin","Testing@Mq");
		
		//to get data from txt file
		String Fpath="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Branch.txt";
		String Rpath="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\results\\RF_BrnchResult.txt";
		
		//read data
		FileReader FR= new FileReader(Fpath);
		BufferedReader BR= new BufferedReader(FR);
		String Sread=BR.readLine();
		System.out.println(Sread);
		
		//Write data
		FileWriter FW= new FileWriter(Rpath);
		BufferedWriter BW= new BufferedWriter(FW);
		BW.write(Sread);
		BW.newLine();
		
		//LOOP------WHILE LOOP
		String SD;
		while((SD=BR.readLine())!=null) {
			System.out.println(SD);
			//Split data
			String SR[]=SD.split("###");
			//String BName, String Address, String Area, String ZipCode, String country, String state, String city
			String BName=SR[0];
			String Address=SR[1];
			String Area=SR[2];
			String ZipCode=SR[3];
			String country=SR[4];
			String state=SR[5];
			String city=SR[6];
			
			String Res=LB.BranchCreation(BName, Address, Area, ZipCode, country, state, city);
			System.out.println(Res);
			
			//results
			BW.write(SD+"###@"+Res);
			BW.newLine();
			
		}
		BW.close();
		BR.close();
	}

}
