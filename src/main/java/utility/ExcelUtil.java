package utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
	static Sheet sheet;
	static Workbook book;
	static HashMap<String, Integer> dict = new HashMap<String, Integer>();

	public static void initUtil(String filePath) throws BiffException, IOException {
		book = Workbook.getWorkbook(new File(filePath));
	}
	public static void setSheet(String sheetName){
		sheet = book.getSheet(sheetName);
		columnDictionary();
	}
	public static int getRowCount() {
		return sheet.getRows();
	}
	public static int getColCount() {
		return sheet.getColumns();
	}
	public static String readCell(int r, int c) {
		return sheet.getCell(c, r).getContents();
	}

	public static String readCell(int r, String colName) {
		return sheet.getCell(dict.get(colName), r).getContents();
	}

	public static void columnDictionary() {
		for (int col = 0; col < sheet.getColumns(); col++) {
			dict.put(readCell(0, col), col);
		}
	}
}
