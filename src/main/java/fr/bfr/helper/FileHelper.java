package fr.bfr.helper;

public class FileHelper<T> {

    public static String writeSql() {
        return "INSERT INTO T_SHIP(id,name,rarity,type,subtype,affiliation)";
    }
}
