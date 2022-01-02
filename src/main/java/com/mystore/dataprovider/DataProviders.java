package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;
import com.mystore.utility.XLUtils;

public class DataProviders {
	NewExcelLibrary obj= new NewExcelLibrary();
	XLUtils obj1= new XLUtils();
	public static String path;
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() throws IOException {
//		path of excel file
		path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";
		// Totals rows count
		int rows = obj1.getRowCount(path, "credentials");
		// Total Columns
		int column = obj1.getCellCount(path, "credentials", rows);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

}
