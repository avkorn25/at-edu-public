package edu;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapper {
    private static Map<String, By> objectMap = new HashMap<>();

    static {
        objectMap.put("Поле поиска", By.name("q"));
        objectMap.put("Кнопка поиска", By.name("btnK"));
    }

    public static By getElementLocatorByName(String name) throws Exception {
        if (!objectMap.containsKey(name)) {
            throw new Exception("Неизвестный элемент " + name);
        } else {
            return objectMap.get(name);
        }
    }
}
