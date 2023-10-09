package com.vmo.demowebshop.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import com.vmo.demowebshop.utils.excelutils.ExcelUtil;

public class DataUtils {
    @DataProvider(name = "assignment")
    public Object[][] getExcelDataTable() {
        Object[][] testObjArray = ExcelUtil.getExcelData();
        return (testObjArray);
    }
}
