package org.example.api_gateway.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient<T> {
    private final String urlAPi;
    private final RestTemplate template;
    private final HttpHeaders httpHeaders;

    public RestClient(String urlAPi) {
        this.urlAPi = urlAPi;
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T getRequest(Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlAPi, HttpMethod.GET, requestEntity, type);
        if (response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

    public T postRequest(Class<T> type, String objectToPost) {
        HttpEntity<String> requestEntity = new HttpEntity<>(objectToPost, httpHeaders);
        ResponseEntity<T> response = template.exchange(urlAPi, HttpMethod.POST, requestEntity, type);
        if (response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

}
