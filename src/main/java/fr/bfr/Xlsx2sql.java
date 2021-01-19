package fr.bfr;

import fr.bfr.helper.ExcelHelper;

import java.io.InputStream;

public class Xlsx2sql {
    public static void main(String[] args) {
        InputStream fileToRead = ClassLoader.getSystemResourceAsStream("azur_lane.xlsx");
        ExcelHelper.exportXlsxData(fileToRead);
    }
}
