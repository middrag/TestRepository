package utilities;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class DatUtils {

	public static String rowName, colName, Result,ExcelLcoation;
	public static WebDriver driver;
	
	public void setExcelLocation(String location_of_xl)
	{
		ExcelLcoation=location_of_xl;
	}

	public void setValue(String rowname) {
		rowName = rowname;
		System.out.println(rowName);
	
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) throws Exception {
		String sheetName = "Sheet5";
		
		ExcelReader excel = new ExcelReader(ExcelLcoation);
		/*
		 * int rowCount = excel.getRowCount(sheetName);
		 * //System.out.println(excel.getCellData(sheetName, 2, 3)); int colCount =
		 * excel.getColumnCount(sheetName);
		 */
		//System.out.println(rowName);
		//System.out.println(sheetName);
		
		int tccount=excel.testCaseRowCount(sheetName, rowName);
		System.out.println(tccount);
		
		int firstRow=excel.testCaseFirstRow(sheetName, rowName);
		System.out.println(firstRow);
		
		int inputColCount=excel.getTestColCount(sheetName,firstRow);
		System.out.println(inputColCount);
		
//		System.out.println(excel.getCellData(sheetName, 0, 2));
//		System.out.println(excel.getCellData(sheetName, "username", 3));
		//System.out.println("Total rows are : " + rowCount + "----total cols are : " + colCount);
		
		

		Object[][] data = new Object[tccount][inputColCount];//need to check how much count we need to put 
		for (int rows = firstRow; rows < tccount+firstRow; rows++) {

			for (int cols = 3; cols < inputColCount+3; cols++) { //3= column count before tst case column starts
//                     int min=rows-firstRow;
//                     int colval=cols-2;
				
                    
				data[rows-firstRow][cols-3] = excel.getCellData(sheetName, cols, rows);
           // System.out.println("data["+min+"]"+"["+colval+"]val="+data[min][colval]);
			}

		}
		return data;
	}

	public static void putwebDriver(WebDriver driver1) {
		driver = driver1;
	}

	public static WebDriver getwebDriver() {
		return driver;
	}
	
	public String randomEmail(String UserName) {
		  
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
	String email=UserName+"+"+ randomInt +"@gmail.com";
	System.out.println("created Email ID"+email);
		return email;
		
	}
	
	public boolean jsComplete(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		   ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			      @Override
			      public Boolean apply(WebDriver driver) {
			        return ((JavascriptExecutor)getwebDriver()).executeScript("return document.readyState")
			        .toString().equals("complete");
			      }
			    };
		return wait.until(jsLoad);	
	}

	
}

//
//@DataProvider(name="dp")
//public Object[][] getData(Method m) throws Exception {
//	String sheetName = m.getName();
//	//System.out.println("sheet name"+sheetName);
//	ExcelUtils excel=new ExcelUtils("C:\\Users\\midhu\\eclipse-workspace\\CarttimizeTestngAutomation\\src\\test\\resources\\testdata.xlsx", "openAccountTest");
//	int first_row=excel.firstRow("customer");
//	int totalRow=excel.totalRowCnt("customer");
//	int first_column=excel.first_column_number(first_row-1, "currency");
//	//System.out.println("First row count  :"+first_row+"totalRow    :"+totalRow);
//	int columncnt=excel.total_column_cnt(first_row-1,first_column,"Result");
//	//System.out.println(first_column+"---total column"+columncnt);
//	
////	int row_Count = excel.firstRow("");
////	int row_last = excel.lastRow("");
//	
//	Object[][] data = new Object[totalRow][columncnt];
//
//	
//	for(int rows=first_row;rows<=totalRow;rows++) {
//		
//		for(int cols=first_column; cols<=columncnt; cols++) {
//			//System.out.println(cols);
//			data[rows-first_row][cols-first_column]=ExcelUtils.getCellData(rows, cols);
//			//System.out.println(data[rows-first_row][cols-first_column]);
//			
//		}
//		
//	}
//	
//	
//	return data;
//	
//}
