package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.model.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.*;

public class TestUtil extends TestBase {
    public TestUtil() throws IOException {
        super();
    }

    private static Logger Log = LogManager.getLogger(TestUtil.class);

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 30;
    //private static FileHelper FileUtils;

    public static Object[][] getExcelData(String fileName, String sheetName) {
        Object[][] data = null;
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook("C:\\Users\\nitha\\IdeaFrameworkProjects\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCRMtestData.xlsx");
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rowsIndex = sheet.getLastRowNum();//return last raw index-index starts from 0
            //Log.info("Total rows:" + rowsIndex);
            data = new Object[rowsIndex][];
            for (int i = 1; i <= rowsIndex; i++) {
                XSSFRow row = sheet.getRow(i);
                int cols = row.getLastCellNum();//returns no:of columns- index start from 0
               // Log.info("total cols:" + cols);
                Object[] colData = new Object[cols];
                for (int j = 0; j < cols; j++) {
                    colData[j] = row.getCell(j).toString();
                }
                data[i - 1] = colData;
            }

        } catch (IOException e) {
           // Log.error("TestUtil exception:" + e);

        } finally {
            try {
                wb.close();
            } catch (IOException e) {

            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileHandler.copy
                (srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }
}






