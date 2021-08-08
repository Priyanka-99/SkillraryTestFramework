package com_SkillRary_genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.DateUtil;

public class ConfigDataProvider extends BaseClass{

	@DataProvider
	public Object[][] fetchData() {
		Object obj[][]=null;

		try {
			FileInputStream fis=new FileInputStream(new File(AutoConstant.excelPath));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			int rowCount = sh.getLastRowNum();
			short cellCount = sh.getRow(1).getLastCellNum();
			obj=new Object[rowCount][cellCount];
			for (int i=1;i<=rowCount;i++) {
				Row rw = sh.getRow(i);
				int cellCt = rw.getLastCellNum();

				if(cellCt==cellCount) {
					for(int j=0;j<cellCt;j++) {

						switch (rw.getCell(j).getCellType()) {
						case STRING:
							obj[i-1][j] = rw.getCell(j).getStringCellValue();
							break;

						case NUMERIC:
							if (DateUtil.isCellDateFormatted(rw.getCell(j))) {
								SimpleDateFormat sdf=new SimpleDateFormat("MMM dd, yyyy");
								obj[i-1][j] = sdf.format(rw.getCell(j).getDateCellValue());
							} 
							else {
								long num = (long) rw.getCell(j).getNumericCellValue();
								obj[i-1][j] = ""+num;
							}
							break;

						default:
							break;
						}
					}
				}
			}
			wb.close();
		}

		catch(EncryptedDocumentException ede) {
			ede.printStackTrace();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return obj;
	}

}
