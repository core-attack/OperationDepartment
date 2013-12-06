package documents;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.tomcat.jni.FileInfo;

import java.util.*;
import java.io.*;
import classes.*;

public class ReadExcelFile {
	public static void main(String[] args) throws Exception{
		//createInsertsForBanks();
		//createInsertsForOperations();
		//createInsertsForBankAccountsFirstOrder();
		createInsertsForBankAccountSecondOrder();
	}
	
	
	//создает скрипт добавления в таблицу-справочник банки из справочника банков
	static void createInsertsForBanks() throws Exception{
		FileInputStream file = new FileInputStream(new File("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/xls/банки.xls"));
		String[] result;
		//Get the workbook instance for XLS file 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		//Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum() + 1;
		result = new String[rows];
		for (int i = 0; i < rows; i++){
			HSSFRow row = sheet.getRow(i);
			Bank bank = new Bank();
			for (short j = 0; j < row.getLastCellNum(); j++){
				HSSFCell cell = row.getCell(j); 
				switch(j){
					case 0: {
						try
						{
							bank.setId(Integer.valueOf(cell.getStringCellValue()));
						}
						catch(NumberFormatException nex)
						{
							System.out.println(nex.getMessage());
							System.out.println("Будет записана -1");
							bank.setId(-1);
						}
					}
					break;
					case 1: bank.setKey(cell.getStringCellValue()); break;
					case 2: bank.setName(cell.getStringCellValue()); break;
					case 3: {
						try
						{
							bank.setBik(Integer.valueOf(cell.getStringCellValue())); 
						}
						catch(NumberFormatException nex)
						{
							System.out.println(nex.getMessage());
							System.out.println("Будет записана -1");
							bank.setBik(-1); 
						}
					}
					break;
					case 4: {
						try
						{
							bank.setAccount(cell.getStringCellValue());
						}
						catch(NumberFormatException nex)
						{
							bank.setAccount("-1");
						}
					}
					break;
					case 5: bank.setPlace(cell.getStringCellValue()); break;
				}
	        }
			System.out.println(bank.toStringToDB());
			result[i] = bank.toStringToDB();
			
			
        }
		FileWriter fw = new FileWriter("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/sql/банки.sql");
		for (int k = 0; k < rows; k++){
			fw.write(result[k].replace("\n", ""));
			fw.write("\n");
		}
		fw.close();
		//Get iterator to all the rows in current sheet
		//Iterator<Row> rowIterator = sheet.iterator();
		 
		//Get iterator to all cells of current row
		//Iterator<Cell> cellIterator = row.cellIterator();
	}
	
	//создает скрипт добавления в таблицу-справочник типы операций из справочника банков
	static void createInsertsForOperations() throws Exception{
		FileInputStream file = new FileInputStream(new File("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/xls/операции.xls"));
		String[] result;
		//Get the workbook instance for XLS file 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		//Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum() + 1;
		result = new String[rows];
		for (int i = 0; i < rows; i++){
			HSSFRow row = sheet.getRow(i);
			Operation op = new Operation();
			for (short j = 0; j < row.getLastCellNum(); j++){
				HSSFCell cell = row.getCell(j); 
				switch(j){
					case 0: {
						try
						{
							op.setId(Integer.valueOf(cell.getStringCellValue()));
						}
						catch(NumberFormatException nex)
						{
							System.out.println(nex.getMessage());
							System.out.println("Будет записана -1");
							op.setId(-1);
						}
					}
					break;
					case 1: op.setName(cell.getStringCellValue()); break;
					case 2: op.set_char(cell.getStringCellValue()); break;
				}
	        }
			System.out.println(op.toStringToDB());
			result[i] = op.toStringToDB();
			
			
        }
		FileWriter fw = new FileWriter("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/sql/операции.sql");
		for (int k = 0; k < rows; k++){
			fw.write(result[k].replace("\n", ""));
			fw.write("\n");
		}
		fw.close();
	}
	
	//создает скрипт добавления в таблицу-справочник счета первого порядка из справочника банков
	static void createInsertsForBankAccountsFirstOrder() throws Exception{
		FileInputStream file = new FileInputStream(new File("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/xls/счета1порядка.xls"));
		String[] result;
		//Get the workbook instance for XLS file 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		//Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum() + 1;
		result = new String[rows];
		for (int i = 0; i < rows; i++){
			HSSFRow row = sheet.getRow(i);
			BankAccountFirstOrder ba1 = new BankAccountFirstOrder();
			for (short j = 0; j < row.getLastCellNum(); j++){
				HSSFCell cell = row.getCell(j); 
				switch(j){
					case 0: {
						try
						{
							ba1.setId(Integer.valueOf(cell.getStringCellValue()));
						}
						catch(NumberFormatException nex)
						{
							System.out.println(nex.getMessage());
							System.out.println("Будет записана -1");
							ba1.setId(-1);
						}
					}
					break;
					case 1: ba1.setNumber(cell.getStringCellValue()); break;
					case 2: ba1.setName(cell.getStringCellValue()); break;
					case 3: {
						try
						{
							ba1.setBfs_code(Integer.valueOf(cell.getStringCellValue()));
						}
						catch(NumberFormatException nex)
						{
							System.out.println(nex.getMessage());
							System.out.println("Будет записана -1");
							ba1.setBfs_code(-1);
						}
					}
					break;
				}
	        }
			System.out.println(ba1.toStringToDB());
			result[i] = ba1.toStringToDB();
        }
		FileWriter fw = new FileWriter("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/sql/счета1порядка.sql");
		for (int k = 0; k < rows; k++){
			fw.write(result[k].replace("\n", ""));
			fw.write("\n");
		}
		fw.close();
	}
	
	//создает скрипт добавления в таблицу-справочник счета первого порядка из справочника банков
		static void createInsertsForBankAccountSecondOrder() throws Exception{
			FileInputStream file = new FileInputStream(new File("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/xls/счета2порядка.xls"));
			String[] result;
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			 
			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			int rows = sheet.getLastRowNum() + 1;
			result = new String[rows];
			for (int i = 0; i < rows; i++){
				HSSFRow row = sheet.getRow(i);
				BankAccountSecondOrder ba2 = new BankAccountSecondOrder();
				for (short j = 0; j < row.getLastCellNum(); j++){
					HSSFCell cell = row.getCell(j); 
					switch(j){
						case 0: {
							try
							{
								ba2.setId(Integer.valueOf(cell.getStringCellValue()));
							}
							catch(NumberFormatException nex)
							{
								System.out.println(nex.getMessage());
								System.out.println("Будет записана -1");
								ba2.setId(-1);
							}
						}
						break;
						case 1: ba2.setNumber(cell.getStringCellValue()); break;
						case 2: ba2.setName(cell.getStringCellValue()); break;
						case 3: ba2.setActivity(cell.getStringCellValue()); break;
						case 4: {
							try
							{
								ba2.setBfs_code(Integer.valueOf(cell.getStringCellValue()));
							}
							catch(NumberFormatException nex)
							{
								System.out.println(nex.getMessage());
								System.out.println("Будет записана -1");
								ba2.setBfs_code(-1);
							}
						}
						break;
						case 5: ba2.setAcc1_number(cell.getStringCellValue()); break;
					}
		        }
				System.out.println(ba2.toStringToDB());
				result[i] = ba2.toStringToDB();
	        }
			FileWriter fw = new FileWriter("C:/Users/Николай/Documents/Университет/5 курс/Банковские ИС/OperationDepartment/WebContent/sql/счета2порядка.sql");
			for (int k = 0; k < rows; k++){
				fw.write(result[k].replace("\n", ""));
				fw.write("\n");
			}
			fw.close();
		}
}
