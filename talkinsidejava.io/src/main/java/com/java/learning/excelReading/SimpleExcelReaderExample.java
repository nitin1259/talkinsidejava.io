/**
 * 
 */
package com.java.learning.excelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
 

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author nsingh
 *
 */
public class SimpleExcelReaderExample {
     
    public static void main(String[] args) throws IOException {
        
    	List<CandidateList>  outList = readBooksFromExcelFile("C:/Users/nsingh/Desktop/12460 eligible 2007-1.xlsx");
    	
    	for(CandidateList cl : outList)
    		System.out.println(cl);
    	
    }
 
    public static List<CandidateList> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<CandidateList> listCandidateLists = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
        Workbook workbook =  getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
     
        //int count=0;
        while (iterator.hasNext()) {
        	
        	// if(count++<6)        		continue;
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            CandidateList aCandidateList = new CandidateList();
     
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
     
                switch (columnIndex) {
                case 1:
                    aCandidateList.setStr1(nextCell.getStringCellValue());
                    break;
                case 2:
                    aCandidateList.setStr2(nextCell.getStringCellValue());
                    break;
                case 3:
                    aCandidateList.setStr3(nextCell.getStringCellValue());
                    break;
                case 4:
                    aCandidateList.setStr4(nextCell.getStringCellValue());
                    break;
                case 5:
                    aCandidateList.setStr5(nextCell.getStringCellValue());
                    break;
                case 6:
                    aCandidateList.setStr6(nextCell.getStringCellValue());
                    break;
                case 7:
                    aCandidateList.setStr7(nextCell.getStringCellValue());
                    break;
                case 8:
                    aCandidateList.setStr8(nextCell.getStringCellValue());
                    break;
                case 9:
                    aCandidateList.setStr9(nextCell.getStringCellValue());
                    break;
                case 10:
                    aCandidateList.setStr10(nextCell.getStringCellValue());
                    break;
                case 11:
                    aCandidateList.setStr11(nextCell.getStringCellValue());
                    break;
                case 12:
                    aCandidateList.setStr12(nextCell.getStringCellValue());
                    break;
                case 13:
                    aCandidateList.setStr13(nextCell.getStringCellValue());
                    break;
                case 14:
                    aCandidateList.setStr14(nextCell.getStringCellValue());
                    break;
                case 15:
                    aCandidateList.setStr15(nextCell.getStringCellValue());
                    break;
                case 16:
                    aCandidateList.setStr16(nextCell.getStringCellValue());
                    break;
                case 17:
                    aCandidateList.setStr17(nextCell.getStringCellValue());
                    break;
                case 18:
                    aCandidateList.setStr18(nextCell.getStringCellValue());
                    break;
                case 19:
                    aCandidateList.setStr19(nextCell.getStringCellValue());
                    break;
                case 20:
                    aCandidateList.setStr20(nextCell.getStringCellValue());
                    break;
                case 21:
                    aCandidateList.setStr21(nextCell.getStringCellValue());
                    break;
                case 22:
                    aCandidateList.setStr22(nextCell.getStringCellValue());
                    break;
                case 23:
                    aCandidateList.setStr23(nextCell.getStringCellValue());
                    break;
                case 24:
                    aCandidateList.setStr24(nextCell.getStringCellValue());
                    break;
                case 25:
                    aCandidateList.setStr25(nextCell.getStringCellValue());
                    break;
                case 26:
                    aCandidateList.setStr26(nextCell.getStringCellValue());
                    break;
                case 27:
                    aCandidateList.setStr27(nextCell.getStringCellValue());
                    break;
                case 28:
                    aCandidateList.setStr28(nextCell.getStringCellValue());
                    break;
                case 29:
                    aCandidateList.setStr29(nextCell.getStringCellValue());
                    break;
                case 30:
                    aCandidateList.setStr30(nextCell.getStringCellValue());
                    break;
                case 31:
                    aCandidateList.setStr31(nextCell.getStringCellValue());
                    break;
                case 32:
                    aCandidateList.setStr32(nextCell.getStringCellValue());
                    break;
                }
     
     
            }
            listCandidateLists.add(aCandidateList);
        }
     
        workbook.close();
        inputStream.close();
     
        return listCandidateLists;
    }
    
    
    
    private Object getCellValue(Cell cell) {
    	    switch (cell.getCellType()) {
    	    case Cell.CELL_TYPE_STRING:
    	        return cell.getStringCellValue();
    	 
    	    case Cell.CELL_TYPE_BOOLEAN:
    	        return cell.getBooleanCellValue();
    	 
    	    case Cell.CELL_TYPE_NUMERIC:
    	        return cell.getNumericCellValue();
    	    }
    	 
    	    return null;
	}

	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;
     
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
     
        return workbook;
    }
}
