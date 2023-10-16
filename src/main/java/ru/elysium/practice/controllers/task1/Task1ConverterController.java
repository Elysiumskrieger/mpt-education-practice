package ru.elysium.practice.controllers.task1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.elysium.practice.lib.CurrencyApi;
import java.util.HashMap;


@Controller
public class Task1ConverterController {

    // Обработчик GET-запроса на страницу конвертера
    @GetMapping("/task1/cash-converter")
    public void converterGet(Model model) {
        try {
            // Получаем список доступных валют и добавляем его в модель
            model.addAttribute("currencies", CurrencyApi.getCurrencies());
        }
        catch (Exception e) {
            // Если возникает ошибка при получении списка валют, добавляем сообщение об ошибке в модель
            model.addAttribute("error", "Список валют недоступен");
        }
    }

    // Обработчик POST-запроса на конвертацию валюты
    @PostMapping("/task1/cash-converter")
    public void converterPost(Model model,
                              @RequestParam(value = "convertFrom") String convertFrom,
                              @RequestParam(value = "convertTo") String convertTo,
                              @RequestParam(value = "value") Double value) {
        try {
            // Получаем список доступных валют и добавляем его в модель
            model.addAttribute("currencies", CurrencyApi.getCurrencies());
        }
        catch (Exception e) {
            // Если возникает ошибка при получении списка валют, добавляем сообщение об ошибке в модель и прекращаем выполнение метода
            model.addAttribute("error", "Список валют недоступен");
            return;
        }
        try {
            // Получаем коэффициент для конвертации выбранных валют и вычисляем результат
            HashMap<String, Double> currency = CurrencyApi.getCurrency(convertFrom);
            Double coff = currency.get(convertTo);
            Double result = value * coff;

            // Добавляем информацию о выбранных валютах, введенном значении и результате конвертации в модель
            model.addAttribute("convertFrom", convertFrom);
            model.addAttribute("convertTo", convertTo);
            model.addAttribute("value", value);
            model.addAttribute("result", result);
        }
        catch (Exception e) {
            // Если возникает ошибка при конвертации валюты, добавляем сообщение об ошибке в модель
            model.addAttribute("error", "Ошибка конвертации");
        }
    }
}