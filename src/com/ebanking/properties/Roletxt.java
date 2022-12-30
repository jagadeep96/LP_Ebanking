package com.ebanking.properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ebanking.master.Library;

public class Roletxt {

	public static void main(String[] args) throws IOException {
		//instance CLASS
		Library LB = new Library();
		LB.LaunchApp("http://103.211.39.246/ranford2/");
		LB.AdminLogin("Admin","Testing@Mq");
		
		//TO read data From filepath
		String Fpath="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
		//to write data in filepath
		String ResPath="D:\\LiveProject\\Ebanking\\src\\com\\ebanking\\results\\RF_RoleResult.txt";		
		//to get test data file		
		FileReader FR= new FileReader(Fpath);
		BufferedReader BR= new BufferedReader(FR);
		String Sread=BR.readLine();
		System.out.println(Sread);
		
		//to write header into results
		FileWriter FW= new FileWriter(ResPath);
		BufferedWriter BW=new BufferedWriter(FW);
		BW.write(Sread);
		BW.newLine();
		
		//LOOP------WhileLOOP
		String SD;		 //SD-string data
		while ((SD=BR.readLine())!=null) {
			System.out.println(SD);			
			//split
			String SR[]=SD.split("###");
			
			String Rname=SR[0];
			String Rtype=SR[1];
			
			String Res=LB.RoleCreation(Rname, Rtype);
			System.out.println(Res);
			//Results
			BW.write(SD+"###@"+Res);
			BW.newLine();
		}
		
		BW.close();
		BR.close();
		
		LB.close();
	}

}
