package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {

    public static Object[][] getdata(String excelpath, String sheetname) throws IOException {
        File file = new File(excelpath);
        System.out.println("Excel file path: " + file.getAbsolutePath());

        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetname);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Assuming all rows have same columns

        System.out.println("Rows: " + rowCount + ", Columns: " + colCount);

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null) {
                    data[i][j] = sheet.getRow(i).getCell(j).toString();
                } else {
                    data[i][j] = ""; // Default to empty string if cell is missing
                }
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}