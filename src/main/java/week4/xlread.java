package week4;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlread {

	public static void main(String[] args) throws IOException {
		updateExcel();
	}

	public static void updateExcel() throws IOException {
		FileInputStream finput = new FileInputStream(new File("./data/output.xlsx"));
		XSSFWorkbook wbook = new XSSFWorkbook(finput);
		XSSFSheet sheet = wbook.getSheet("TestOutput");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.createCell(1);
		cell.setCellValue("Test Case");

		// create 2nd row
		sheet.getRow(2).createCell(1).setCellValue("Create Leadnm");

		try {
			// Create this when you need to write / update
			FileOutputStream fileOutput = new FileOutputStream(new File(".data/output.xlsx"));
			wbook.write(fileOutput);

			wbook.close();
			fileOutput.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeExcel() {
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheet = wbook.createSheet("TestOutput");
		XSSFRow row = sheet.createRow(1);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Serial No");

		// create 2nd row
		sheet.createRow(2).createCell(0).setCellValue("1");

		try {
			// Create this when you need to write / update
			FileOutputStream fileOutput = new FileOutputStream(new File(".data/output.xlsx"));
			wbook.write(fileOutput);

			wbook.close();
			fileOutput.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
