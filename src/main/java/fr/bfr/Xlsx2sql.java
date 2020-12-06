package fr.bfr;

import fr.bfr.helper.ExcelHelper;

import java.io.InputStream;

public class Xlsx2sql {
    public static void main(String[] args) {
        InputStream FileToRead = ClassLoader.getSystemResourceAsStream("azur_lane.xlsx");
        ExcelHelper.exportXlsxData(FileToRead);
    }
}
