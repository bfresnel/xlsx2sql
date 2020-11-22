package fr.bfr.helper;

public class FileHelper<T> {

    public static String QUOTE = "'";

    public static String writeSql() {
        StringBuilder sb = new StringBuilder(
                "INSERT INTO T_SHIP(id,name,rarity,type,subtype,affiliation)"
        );

        return sb.toString();
    }
}
