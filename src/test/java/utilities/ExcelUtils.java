//package utilities;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtils {
//
//	private static XSSFSheet ExcelWSheet;
//
//	private static XSSFWorkbook ExcelWBook;
//
//	private static XSSFCell Cell;
//
//	private static XSSFRow Row;
//	public static int totalcnt;
//
//	// This method is to set the File path and to open the Excel file, Pass Excel
//	// Path and Sheetname as Arguments to this method
//
//	public ExcelUtils(String Path, String SheetName) throws Exception {
//
//		try {
//
//			// Open the Excel file
//
//			FileInputStream ExcelFile = new FileInputStream(Path);
//
//			// Access the required test data sheet
//
//			ExcelWBook = new XSSFWorkbook(ExcelFile);
//
//			ExcelWSheet = ExcelWBook.getSheet(SheetName);
//
//		} catch (Exception e) {
//
//			throw (e);
//
//		}
//
//	}
//
//	// This method is to read the test data from the Excel cell, in this we are
//	// passing parameters as Row num and Col num
//
//	public static String getCellData(int RowNum, int ColNum) throws Exception {
//
//		try {
//
//			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
//
//			String CellData = Cell.getStringCellValue();
//			// System.out.println(CellData);
//
//			return CellData;
//
//		} catch (Exception e) {
//
//			return "";
//
//		}
//
//	}
//
//	// This method is to write in the Excel cell, Row num and Col num are the
//	// parameters
//
//	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
//
//		try {
//
//			Row = ExcelWSheet.getRow(RowNum);
//
//			Cell = Row.getCell(ColNum, Row.);
//			if (Cell == null) {
//
//				Cell = Row.createCell(ColNum);
//
//				Cell.setCellValue(Result);
//
//			} else {
//
//				Cell.setCellValue(Result);
//
//			}
//
//			// Constant variables Test Data path and Test Data file name
//
//			FileOutputStream fileOut = new FileOutputStream("");
//
//			ExcelWBook.write(fileOut);
//
//			fileOut.flush();
//
//			fileOut.close();
//
//		} catch (Exception e) {
//
//			throw (e);
//
//		}
//
//	}
//
//	public static int InputSuite(String inputfnname) throws Exception {
//		System.out.println(inputfnname);
//		int TotalcountRow = ExcelWSheet.getPhysicalNumberOfRows();
//		System.out.println(TotalcountRow);
//		int i = 1;
//		totalcnt = 0;
//		while (i <= TotalcountRow) {
//			String str = getCellData(i, 0);
//			Boolean b = str.contains(inputfnname);
//
//			if (b == true) {
//				totalcnt++;
//				i++;
//			} else {
//				i++;
//			}
//		}
//		System.out.println(totalcnt);
//		return totalcnt;
//	}
//
//	public int firstRow(String inputfnname) throws Exception {
//		int TotalcountRow = ExcelWSheet.getPhysicalNumberOfRows();
//
//		int i = 1;
//		totalcnt = 0;
//		while (i <= TotalcountRow) {
//
//			String str = getCellData(i, 0); // to get the given Test case name
//
//			Boolean b = str.contains(inputfnname);
//
//			if (b == true) {
//				totalcnt = i;
//				i = TotalcountRow + 1;
//			} else {
//				i++;
//			}
//		}
//
//		return totalcnt;
//	}
//
//	public int lastRow(String inputfnname) throws Exception {
//		int TotalcountRow = ExcelWSheet.getPhysicalNumberOfRows();
//
//		System.out.println("total count row check " + TotalcountRow);
//
//		int i = 1;
//	int totalcnt = 0;
//		while (i <= TotalcountRow) {
//
//			String str = getCellData(i, 0); // to get the given Test case name
//
//			Boolean b = str.contains(inputfnname);
//
//			if (b == true) {
//				totalcnt = i;
//				i++;
//				System.out.println("i vlue chekc" + i);
//			} else {
//				i++;
//
//			}
//
//		}
//
//		return totalcnt;
//	}
//
//	public int totalRowCnt(String inputfnname) throws Exception {
//		int TotalcountRow = ExcelWSheet.getPhysicalNumberOfRows();
//
//		System.out.println("total count row check " + TotalcountRow);
//
//		int i = 1;
//		int cnt=0;
//		
//	int totalcnt = 0;
//		while (i <= TotalcountRow) {
//
//			String str = getCellData(i, 0); // to get the given Test case name
//
//			Boolean b = str.contains(inputfnname);
//
//			if (b == true) {
//				totalcnt = i;
//				i++;
//				cnt++;
//				//System.out.println("i vlue chekc" + i);
//			} else {
//				i++;
//
//			}
//
//		}
//
//		return cnt;
//	}
//	public int first_column_number(int rownumber, String start_string) {
//		int cellcnt = ExcelWSheet.getRow(rownumber).getPhysicalNumberOfCells();
//		//System.out.println("cell cnt"+cellcnt);
//		int startcount = 0;
//
//		for (int cnt = 1; cnt <cellcnt; cnt++) {
//			
//			System.out.println(ExcelWSheet.getRow(rownumber).getCell(cnt).getStringCellValue());
//			
//			if(ExcelWSheet.getRow(rownumber).getCell(cnt).getStringCellValue() != null)
//			{
//				String val = ExcelWSheet.getRow(rownumber).getCell(cnt).getStringCellValue();
//				//System.out.println(val);
//				if (val.contains(start_string)) {
//					
//					startcount = cnt;
//				//	System.out.println("midhu :"+startcount);
//					cnt=cellcnt+1;
//				}
//
//				
//			}
//
//			
//		}
//		
//
//		return startcount;
//
//	}
//
//	public int Last_column_number(int rownumber, String end_String) {
//		int cellcnt = ExcelWSheet.getRow(rownumber).getPhysicalNumberOfCells();
//		int endcnt = 0;
//
//		for (int cnt = 1; cnt < cellcnt; cnt++) {
//
//			String val = ExcelWSheet.getRow(rownumber).getCell(cnt).getStringCellValue();
//			if (val.contains(end_String)) {
//				endcnt = cnt;
//				//System.out.println("midhu :"+endcnt);
//				cnt = cellcnt+1;
//
//			}
//		}
//
//		return endcnt;
//
//	}
//
//	public int total_column_cnt(int rownumber,int first_colnum, String end_String) {
//		int cellcnt = ExcelWSheet.getRow(rownumber).getPhysicalNumberOfCells();
//		int endcnt = 0;
//		int tcnt=0;
//
//		for (int cnt = first_colnum; cnt < cellcnt; cnt++) {
//
//			String val = ExcelWSheet.getRow(rownumber).getCell(cnt).getStringCellValue();
//			if (val.contains(end_String)) {
//				endcnt = cnt;
//				//System.out.println("midhu :"+endcnt);
//				cnt = cellcnt+1;
//
//			}
//			tcnt++;
//		}
//
//		return tcnt;
//
//	}
//}