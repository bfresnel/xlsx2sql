package fr.bfr;

import fr.bfr.helper.ExcelHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Hello world!
 */
public class Xlsx2sql {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + File.separator + "azur_lane.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            ExcelHelper.exportXlsxData(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
