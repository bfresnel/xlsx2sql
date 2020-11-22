package fr.bfr.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String excelToShip(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<String> entite = new ArrayList<String>();

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
                    if (cellIdx > 0) {
                        sb.append(",");
                    }
                    Cell currentCell = cellsInRow.next();
                    sb.append(currentCell.getStringCellValue());
                    cellIdx++;
                }
                entite.add(ligne);
            }
            workbook.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
