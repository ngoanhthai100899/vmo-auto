package com.vmo.demowebshop.utils.excelutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
public class ExcelUtil {
    public static final String       testDataExcelFileName = "assignment.xlsx"; //Global test data excel file
    public static final String       currentDir            = System.getProperty("C:\\Users\\ngoan\\Desktop\\vmo-auto");  //Main Directory of the project
    public static       String       testDataExcelPath     = "src\\main\\resources\\"; //Location of Test data excel file
    private static      XSSFWorkbook excelWBook; //Excel WorkBook
    private static      XSSFSheet    excelWSheet; //Excel Sheet
    private static      XSSFCell     cell; //Excel cell
    private static      XSSFRow      row; //Excel row
    public static       int          rowNumber; //Row Number
    public static       int          columnNumber; //Column Number
    // This method has two parameters: "Test data Excel file name" and "Excel sheet name"
    // It creates FileInputStream and set Excel file and Excel sheet to excelWBook and excelWSheet variables.
    @SneakyThrows
    public static void setExcelFileSheet(String sheetName) {
        //MAC or Windows Selection for Excel path
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "/src/main/resources/";
        } else if (Platform.getCurrent().toString().contains("win")) {
            testDataExcelPath = currentDir + "\\src\\main\\resources\\";
        }
        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
    }
    public static int getRowNumber(){
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getPhysicalNumberOfRows();
    }
    public static int getColumnNumber(){
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getRow(0).getLastCellNum();
    }
    public static String getDataValue(int rowNum, int colNum){
        excelWSheet = excelWBook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        try {
            return formatter.formatCellValue(excelWSheet.getRow(rowNum).getCell(colNum));
        }catch (NullPointerException e){
            e.printStackTrace();
            return "";
        }
    }
    public static Object[][] getExcelData(){
        int rowNum = getRowNumber();
        int colNum = getColumnNumber();
        Object[][] objects = new Object[rowNum-1][colNum];
        for (int i = 1; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                objects[i-1][j]= getDataValue(i,j);
            }
        }
        return objects;
    }
    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(RowNum);
        return row;
    }
    //This method gets excel file, row and column number and set a value to the that cell.
    @SneakyThrows
    public static void setCellData(String value, int RowNum, int ColNum) {
        row = excelWSheet.getRow(RowNum);
        cell = row.getCell(ColNum);
        if (cell == null) {
            cell = row.createCell(ColNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        // Constant variables Test Data path and Test Data file name
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
