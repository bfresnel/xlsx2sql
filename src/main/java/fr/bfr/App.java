package fr.bfr;

import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String valeur : env.keySet()) {
            System.out.println(valeur + " : " + env.get(valeur));
        }
        Properties properties = System.getProperties();
        System.out.println(properties.toString());
        System.out.println(properties.getProperty("user.dir"));
    }
}
