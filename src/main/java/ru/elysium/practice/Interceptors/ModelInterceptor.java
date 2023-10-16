package ru.elysium.practice.Interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class ModelInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            // Получаем все атрибуты модели
            Map<String, Object> modelAttributes = modelAndView.getModel();

            // Преобразуем атрибуты модели в JSON строку
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonAttributes = objectMapper.writeValueAsString(modelAttributes);

            // Создаем base64 закодированную строку
            String base64EncodedAttributes = new String(Base64.getEncoder().encode(jsonAttributes.getBytes(StandardCharsets.UTF_8)));

            // Добавляем атрибут pageContext к модели
            modelAndView.addObject("pageContext", base64EncodedAttributes);

            // Устанавливаем имя шаблона index
            modelAndView.setViewName("index");
        }
    }
}
