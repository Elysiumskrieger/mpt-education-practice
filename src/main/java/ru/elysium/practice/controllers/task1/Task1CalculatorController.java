package ru.elysium.practice.controllers.task1;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Task1CalculatorController {

    // Обработчик GET-запроса на страницу калькулятора
    @GetMapping("/task1/calculator")
    public void calculatorGet() {}

    // Обработчик POST-запроса на вычисление выражения
    @PostMapping("/task1/calculator")
    public void calculatorPost(Model model, @RequestParam(value = "ex", defaultValue = "0") String ex) {
        // Создаем объект Expression для вычисления выражения
        Expression expression = new Expression(ex);
        try {
            // Вычисляем результат выражения
            EvaluationValue result = expression.evaluate();
            model.addAttribute("result",  result.getNumberValue());
        }
        catch (ParseException exception){
            // Если возникает ошибка при разборе выражения, добавляем сообщение об ошибке в модель
            model.addAttribute("error",  "Некорректное выражение");
        }
        catch (EvaluationException exception){
            // Если возникает ошибка при вычислении выражения, добавляем сообщение об ошибке в модель
            model.addAttribute("error",  "Ошибка вычисления");
        }
        // Добавляем введенное пользователем выражение в модель
        model.addAttribute("ex", ex);
    }
}