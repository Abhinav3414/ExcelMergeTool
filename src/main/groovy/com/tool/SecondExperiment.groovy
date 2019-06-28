package com.tool


import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.WorkbookUtil
import org.apache.poi.xssf.usermodel.XSSFDataFormat
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import groovy.transform.Sortable
import groovy.transform.ToString

String filePath = "C:/Users/abhinavg/Desktop/groovy/";
String inputFile = filePath + "abc.xlsx"
println "Input file is : " + inputFile

@ToString(includeNames=true, includeFields=true, excludes='active')
class Data {
	String name
	Integer id
	Date logDate
	def active
}

def fillClass(int columnVal, def value, Data dataClass) {
	switch (columnVal) {
		case 0:
			dataClass.name = value
			break;
		case 1:
			dataClass.id = value;
			break;
		case 2:
			dataClass.logDate = value
			break
	}
}

def fileAsList  = [] as LinkedList

def storeSheetDataInList(XSSFSheet sheet, LinkedList list) {
	def dateColumnNumber = 2
	def rowNumber = 0

	for (Row row : sheet) {

		def columnNumber = 0
		def tempClass = new Data()

		for (Cell cell : row) {

			def tempCol
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if(columnNumber == dateColumnNumber && rowNumber>0) {
						tempCol = row.getCell(columnNumber).getDateCellValue()
						print (tempCol);
					} else {
						tempCol = cell.getNumericCellValue()
						print (tempCol + "\t");
					}
					break;
				case Cell.CELL_TYPE_STRING:
					tempCol = cell.getStringCellValue()
					print (tempCol + "\t");
					break;
			}
			if(rowNumber != 0) {
				fillClass(columnNumber, tempCol, tempClass)
			}

			columnNumber++
		}

		println ""
		if(rowNumber != 0) {
			list.add(tempClass)
		}

		rowNumber++
	}
}



try {

	OPCPackage pkg = OPCPackage.open(new File(inputFile));
	XSSFWorkbook workbook = new XSSFWorkbook(pkg);

	println "Storing Worksheets in Memory"
	storeSheetDataInList(workbook.getSheetAt(0), fileAsList)
	storeSheetDataInList(workbook.getSheetAt(1), fileAsList)

	pkg.close();
}
catch (Exception e) {
	e.printStackTrace();
}

println "Sorting list (as per Date)"
def list = fileAsList.collect { it }
list.sort{ x,y ->
	x.logDate <=> y.logDate
}

println "Sorted list is: "
list.each { println it }

OutputStream fileOut = new FileOutputStream(filePath + "workbook.xlsx")
Workbook outWb = new XSSFWorkbook();

String safeName1 = WorkbookUtil.createSafeSheetName("DataSheet1")
String safeName2 = WorkbookUtil.createSafeSheetName("second sheet")

Sheet sheet1 = outWb.createSheet(safeName1);
Sheet sheet2 = outWb.createSheet(safeName2);

CreationHelper createHelper = outWb.getCreationHelper();

Row row = sheet1.createRow(0);

row.createCell(0).setCellValue(createHelper.createRichTextString("Name"));
row.createCell(1).setCellValue(createHelper.createRichTextString("Id"))
row.createCell(2).setCellValue(createHelper.createRichTextString("Date"));

def index = 0;

for(Data listRow : list) {
	Row tempRow = sheet1.createRow(++index);

	tempRow.createCell(0).setCellValue(listRow.name);
	tempRow.createCell(1).setCellValue(listRow.id)

	Cell cellTemp = tempRow.createCell(2);

	CellStyle cellStyle = outWb.createCellStyle();
	cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));

	cellTemp.setCellStyle(cellStyle)
	cellTemp.setCellValue(listRow.logDate)
}

try {
	println "Writing data to file"
	outWb.write(fileOut);
	println "Writing data is completed Successfully !!!!"
} catch(Exception e) {
}
