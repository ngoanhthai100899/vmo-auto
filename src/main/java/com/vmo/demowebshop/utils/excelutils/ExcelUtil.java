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
    public static final String       currentDir            = System.getProperty("C:\\Users\\Ngo Anh Thai\\Documents\\GitHub\\vmo-auto");  //Main Directory of the project
    public static       String       testDataExcelPath     = "src\\main\\resources\\"; //Location of Test data excel file
    private static      XSSFWorkbook excelWBook; //Excel WorkBook
    private static      XSSFSheet    excelWSheet; //Excel Sheet
    private static      XSSFCell     cell; //Excel cell
    private static      XSSFRow      row; //Excel row
    public static       int          rowNumber; //Row Number
    public static       int          columnNumber; //Column Number
    @SneakyThrows
    public static void setExcelFileSheet(String sheetName) {
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "/src/main/resources/";
        } else if (Platform.getCurrent().toString().contains("win")) {
            testDataExcelPath = currentDir + "\\src\\main\\resources\\";
        }
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
}
