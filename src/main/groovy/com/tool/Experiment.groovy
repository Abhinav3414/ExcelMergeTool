package com.tool

/*import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFDateUtil
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.*;

print 'Hello World!!'

String filePath = "C:/Users/abhinavg/Desktop/groovy/abc.xlsx";

//params

def dateColumnNumber = 2;

def fs = new FileInputStream(filePath);
def wb = new XSSFWorkbook(fs)



def ws = wb.getSheet("Sheet2")
def r = ws.getPhysicalNumberOfRows()

println "total row are $r"

for(def k = 0; k< r; k++) {
	def row = ws.getRow(k)

	//println "row $k is $row"
	def c = row.getPhysicalNumberOfCells()

	println "Row No.: " + row.getRowNum()
	println "number of columns : $c"
	
	for(def j = 0; j<c ; j++) {
		

//println row.getCell(j).getStringCellValue()

if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING)
	System.out.println (row.getCell(j).getStringCellValue());

	if (HSSFDateUtil.isCellDateFormatted(row.getCell(j)))
		System.out.println (row.getCell(j).getDateCellValue())
		
	if (j!=dateColumnNumber && row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
		System.out.println (row.getCell(j).getNumericCellValue());

		if(j==dateColumnNumber && k>0) {
			Date birthdate = row.getCell(j).getDateCellValue();
			System.out.println("Date is :" + birthdate);
		}
		
		
		if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING)
			System.out.println ("Row No.: " + row.getRowNum()+ " " + row.getCell(j).getStringCellValue());


		if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
			System.out.println ("Row No.: " + row.getRowNum()+ " " + row.getCell(j).getNumericCellValue());


		if (HSSFDateUtil.isCellDateFormatted(row.getCell(j)))
			System.out.println ("Row No.: " + row.getRowNum()+ " " + row.getCell(j).getDateCellValue());
	}
	
	
	println "----"
}

FileInputStream excelFile = new FileInputStream(new File(filePath));
Workbook originalWorkbook = new XSSFWorkbook(excelFile);

Sheet originalSheet = wb.getSheetAt(1)

boolean sorting = true;
int lastRow = sheet.getLastRowNum();


	while (sorting) {
	   sorting = false;
	   for (Row row : sheet) {
		   if (row.getRowNum() < rowStart) continue;
		   if (lastRow == row.getRowNum()) break;
		   Row nextRow = sheet.getRow(row.getRowNum() + 1);
		   if (nextRow == null) continue;
		   Date firstValue = row.getCell(column).getDateCellValue() ;
		   Date secondValue = nextRow.getCell(column).getDateCellValue() ;
		   if (secondValue.before(firstValue)) {
			   sheet.shiftRows(nextRow.getRowNum(), nextRow.getRowNum(), -1);
			   sheet.shiftRows(row.getRowNum(), row.getRowNum(), 1);
			   sorting = true;
		   }
	   }
	}

*/