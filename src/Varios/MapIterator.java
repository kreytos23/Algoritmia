package Varios;

import java.awt.desktop.SystemEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapIterator {
    public static void main(String[] args) {
        Map<String, Integer> diccionario = new TreeMap<>();

        diccionario.put("Laura", 20);
        diccionario.put("Cesar", 30);
        diccionario.put("Bicha", 40);
        diccionario.put("Calabazo", 50);

        diccionario.forEach((key, value) -> System.out.println(key + " " + value));

        for (Map.Entry<String, Integer> entry: diccionario.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
