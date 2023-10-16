package ru.elysium.practice.lib;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CurrencyApi {
    // Метод для получения списка доступных валют
    public static List<String> getCurrencies() {
        try {
            // Получаем JSON-строку с помощью метода GET из класса Http
            String json = Http.get("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies.json");

            List<String> currencies = new ArrayList<>();

            // Создаем объект ObjectMapper для работы с JSON
            ObjectMapper objectMapper = new ObjectMapper();
            // Преобразуем JSON-строку в дерево узлов JsonNode
            JsonNode jsonNode = objectMapper.readTree(json);
            // Получаем итератор по именам полей в дереве узлов
            Iterator<String> fieldNames = jsonNode.fieldNames();

            // Проходим по всем полям и добавляем их в список валют
            while (fieldNames.hasNext()) {
                currencies.add(fieldNames.next());
            }

            return currencies;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для получения информации о заданной валюте
    public static HashMap<String, Double> getCurrency(String name) {
        // Формируем URL для запроса информации о заданной валюте
        String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + name + ".json";

        try {
            // Получаем JSON-строку с помощью метода GET из класса Http
            String json = Http.get(url);

            HashMap<String, Double> currency = new HashMap<>();

            // Создаем объект ObjectMapper для работы с JSON
            ObjectMapper objectMapper = new ObjectMapper();
            // Преобразуем JSON-строку в дерево узлов JsonNode и получаем узел с информацией о заданной валюте
            JsonNode jsonNode = objectMapper.readTree(json).get(name);
            // Получаем итератор по именам полей в дереве узлов
            Iterator<String> fieldNames = jsonNode.fieldNames();

            // Проходим по всем полям и добавляем их в HashMap currency в качестве ключей и значений
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                Double value = jsonNode.get(fieldName).asDouble();
                currency.put(fieldName, value);
            }

            return currency;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
