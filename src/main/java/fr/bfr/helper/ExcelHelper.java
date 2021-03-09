package fr.bfr.helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public final static Logger logger = LoggerFactory.getLogger(ExcelHelper.class);

    public static void exportXlsxData(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<String> entite = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber <= 1) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                StringBuilder ligne = new StringBuilder("");

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    CellType cellType = currentCell.getCellType();
                    switch (cellType) {
                        case NUMERIC:
                            long longValue = (long) currentCell.getNumericCellValue();
                            ligne.append(longValue);
                            break;
                        case STRING:
                            String stringValue = currentCell.getStringCellValue();
                            if (cellIdx > 0) {
                                ligne.append(",");
                            }
                            ligne.append(formatToStringValue(stringValue));
                            break;
                        default:
                            break;
                    }
                    cellIdx++;

                }
                entite.add(ligne.toString());
            }
            workbook.close();
            for (String ligne : entite) {
                logger.debug("INSERT INTO T_SHIP() VALUES (" + ligne + ")");
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private static String formatToStringValue(String stringValue) {
        return "'" + stringValue + "'";
    }
}
