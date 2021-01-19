package fr.bfr.helper;

/**
 * Class making things.
 *
 * @param <T> the generic type
 */
public class FileHelper<T> {

  /**
   * Writing some SQL.
   *
   * @return sql request
   */
  public static String writeSql() {
    return "INSERT INTO T_SHIP(id,name,rarity,type,subtype,affiliation)";
  }
}
