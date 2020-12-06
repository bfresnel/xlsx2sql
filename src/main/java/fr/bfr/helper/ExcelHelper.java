package fr.bfr.helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static List<Object> exportXlsxData(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Object> entite = new ArrayList<Object>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber <= 1) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                String ligne = new String();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    CellType cellType = currentCell.getCellType();
                    switch (cellType) {
                        case NUMERIC:
                            System.out.println("This cell is in numeric format");
                            long longValue = (long) currentCell.getNumericCellValue();
                            ligne = ligne + "," + longValue;
                            break;
                        case STRING:
                            System.out.println("This cell is in a string format");
                            String stringValue = currentCell.getStringCellValue();
                            ligne = ligne + ", \'" + stringValue + "\'";
                            break;
                        default:
                            System.out.println("Unsupported format yet");
                            break;
                    }
                    cellIdx++;
                }
                entite.add(ligne);
            }
            workbook.close();
            return entite;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private void convertCellToStringFormat(Cell cell) {
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case NUMERIC:
                System.out.println("This cell is in numeric format");
                break;
            case STRING:
                System.out.println("This cell is in a string format");
                break;
            default:
                System.out.println("Unsupported format yet");
                break;
        }
    }
}
