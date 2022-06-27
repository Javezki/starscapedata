package com.github.javezki;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

    public static File file;

    private HashMap<String, String> attributes;

    // Constructor initalizes FileInputStream, no params
    public ReadData(String ship) {
        
        file = getFile();

        this.attributes = getShipStats(ship);
    }

    protected File getFile()
    {
        Path path = Paths.get("");
        String stringPath = path.toAbsolutePath().toString()
                + "\\src\\main\\java\\com\\github\\javezki\\resources\\CombatDataRaw.xlsx";
        return new File(stringPath);
    }

    /**
     * 
     * @return The main data workbook in XSSF format
     */
    protected XSSFWorkbook getShipData() {

        try {
            return new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading / getting spreadsheet!");
            return null;
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Wrong Format!");
            return null;
        }
    }

    /**
     * 
     * @return Returns the main ship data sheet
     */
    protected XSSFSheet getMainShipSheet() {
        return getShipData().getSheet("Ship Raw Data (DO NOT CHANGE)");
    }

    protected void printAllData() {
        Iterator<Row> rIterator = getMainShipSheet().rowIterator();
        while (rIterator.hasNext()) {
            Row row = rIterator.next();
            Iterator<Cell> cIterator = row.cellIterator();

            while (cIterator.hasNext()) {
                Cell cell = cIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " \t");
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("");
    }

    /**
     * 
     * @param column The column to get the cell from
     * @param str    The string keyword
     * @return The cell that the string is found in
     */
    protected Cell getCellFromColumnContainsStr(int column, String str) {
        int columnIndex = 0;
        // The first row index; until bottom of row; plus 1 row iterate
        for (int rowIndex = 0; rowIndex < getMainShipSheet().getPhysicalNumberOfRows(); rowIndex++) {
            Row row = CellUtil.getRow(rowIndex, getMainShipSheet());
            Cell cell = CellUtil.getCell(row, columnIndex);
            if (cell.getStringCellValue().equalsIgnoreCase(str)) {
                return cell;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 
     * @return ArrayList of all attributes related to a ships combat abilities
     */

    protected HashMap<Integer, String> getAttributesFromSheet() {
        HashMap<Integer, String> list = new HashMap<>();
        Row row = getMainShipSheet().getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            list.put(i, cell.getStringCellValue());
        }
        return list;
    }

    public HashMap<String, String> getAttributes()
    {
        return attributes;
    }

    /*
     * Get cell that contains ship then gets row for that ship
     * Iterates through the row and adds to hasmap that's keys are attributes 
     * Returns that map
     */

    protected HashMap<String, String> getShipStats(String ship) {

        Cell cell = getCellFromColumnContainsStr(0, ship);
        HashMap<Integer, String> attributes = getAttributesFromSheet();
        HashMap<String, String> stats = new HashMap<>();
        Row row = getMainShipSheet().getRow(cell.getRowIndex());
        for (int i = 0; i < row.getLastCellNum(); i++) {
            switch (row.getCell(i).getCellType()) {
                case STRING:
                    stats.put(attributes.get(i), row.getCell(i).getStringCellValue());
                    break;
                case NUMERIC:
                    stats.put(attributes.get(i), Double.toString(row.getCell(i).getNumericCellValue()));
                default:
                    break;
            }

        }
        return stats;
    }

    /**
     * 
     * @param type Attribute enum 
     * @return  Value of enum of ship
     */
    protected String getAttribute(ATTR_TYPE type)
    {
        return attributes.get(type.label);
    }

}
