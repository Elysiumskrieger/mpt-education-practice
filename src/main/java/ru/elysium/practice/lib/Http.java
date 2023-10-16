package ru.elysium.practice.lib;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Http {
    public static String get(String url) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200){
            return response.getBody();
        }
        else {
            throw new RuntimeException(response.getStatusCode().toString());
        }
    }
}
