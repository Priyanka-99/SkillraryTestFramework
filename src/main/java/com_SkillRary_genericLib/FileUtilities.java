package com_SkillRary_genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import com.mysql.jdbc.Driver;

/**
 * Contains reusable methods to read the data from external resources
 * @author Priyanka
 *
 */

public class FileUtilities {

	public static Connection con;
	/**
	 * Used to read the data from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilePath));
		return p.getProperty(key);
	}

	/**
	 * Get the Connection to database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDb() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","Priyanka@99");
		return con;
	}

	/**
	 * To execute the query
	 * @param query
	 * @param column
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static String queryExecution(String query, int column, String expectedData) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		while(result.next()) {
			if(result.getString(column).equals(expectedData)) {
				break;
			}else {
				Reporter.log("Data not found",true);
			}
		}
		return expectedData;
	}

	/**
	 * To close the database connection
	 * @throws SQLException
	 */
	public void closeDb() throws SQLException {
		con.close();
	}

	/**
	 * To read the data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

	/**
	 * To read data using DataProvider
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 * 
	 */
	public Object readExcelData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rowNum=sh.getLastRowNum();
		short cellNum = sh.getRow(1).getLastCellNum();
		Object obj[][]=new Object[rowNum][cellNum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;


	}
}
