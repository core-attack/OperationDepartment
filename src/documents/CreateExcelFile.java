package documents;
import  java.io.*;  
import  java.util.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class CreateExcelFile{
    public static void main(String[]args){
		try{
		String filename="C://Users//Николай//Documents//Университет//5 курс//Банковские ИС//OperationDepartment//xls//hello2.xls" ;
		HSSFWorkbook hwb=new HSSFWorkbook();
		HSSFSheet sheet =  hwb.createSheet("new sheet");
		//столбцы
		HSSFRow rowhead=   sheet.createRow((short)0);
		rowhead.createCell((short) 0).setCellValue("SNo");
		rowhead.createCell((short) 1).setCellValue("First Name");
		rowhead.createCell((short) 2).setCellValue("Last Name");
		rowhead.createCell((short) 3).setCellValue("Username");
		rowhead.createCell((short) 4).setCellValue("E-mail");
		rowhead.createCell((short) 5).setCellValue("Country");
		
		//колонки
		HSSFRow row=   sheet.createRow((short)1);
		row.createCell((short) 0).setCellValue("1");
		row.createCell((short) 1).setCellValue("Rose");
		row.createCell((short) 2).setCellValue("India");
		row.createCell((short) 3).setCellValue("roseindia");
		row.createCell((short) 4).setCellValue("hello@roseindia.net");
		row.createCell((short) 5).setCellValue("India");
		
		FileOutputStream fileOut =  new FileOutputStream(filename);
		hwb.write(fileOut);
		fileOut.close();
		System.out.println("Your excel file has been generated!");
		
		} catch ( Exception ex ) {
		    System.out.println(ex);
		
		}
    }
		
	//создает файл exel
	public void createXLS(String filename, String paymentType, Map<String, String> rows){
		try{
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet(paymentType);
			
			/*for (int i = 0; i < rows.size(); i++){
				HSSFRow rowhead = sheet.createRow((short)i);
				rowhead.createCell((short) 0)
			}
			
			//столбцы
			
			rowhead.createCell((short) 0).setCellValue("SNo");
			rowhead.createCell((short) 1).setCellValue("First Name");
			rowhead.createCell((short) 2).setCellValue("Last Name");
			rowhead.createCell((short) 3).setCellValue("Username");
			rowhead.createCell((short) 4).setCellValue("E-mail");
			rowhead.createCell((short) 5).setCellValue("Country");
			
			//колонки
			HSSFRow row=   sheet.createRow((short)1);
			row.createCell((short) 0).setCellValue("1");
			row.createCell((short) 1).setCellValue("Rose");
			row.createCell((short) 2).setCellValue("India");
			row.createCell((short) 3).setCellValue("roseindia");
			row.createCell((short) 4).setCellValue("hello@roseindia.net");
			row.createCell((short) 5).setCellValue("India");
			
			FileOutputStream fileOut =  new FileOutputStream(filename);
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");*/
			
			} catch ( Exception ex ) {
			    System.out.println(ex);
			}
	}
}