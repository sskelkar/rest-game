package com.tw.restgame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.restgame.com.tw.stage.one.Input;
import com.tw.restgame.com.tw.stage.one.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

public class HttpCaller {
    private static final ObjectMapper mapper = new ObjectMapper();
    private String serverUrl;
    private RestTemplate restTemplate;

    public HttpCaller(String serverUrl, RestTemplate restTemplate) {
        this.serverUrl = serverUrl;
        this.restTemplate = restTemplate;
    }

    public <T> T getInput(Class<T> clazz) {
        String inputUrl = serverUrl + "/challenge/input";
        System.out.println("Input request url: " + inputUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("userId", "cjramvOaj");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(inputUrl, GET, request, String.class);
        System.out.println("Received input: " + response.getBody());
        try {
            return mapper.readValue(response.getBody(), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Could not parse input: " + response.getBody());
        }
    }

    public <T> void sendOutput(T output) {
        try {
            System.out.println("Posting output: " + mapper.writeValueAsString(output));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String outputUrl = this.serverUrl + "/challenge/output";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("userId", "cjramvOaj");
        HttpEntity<T> request = new HttpEntity<>(output, headers);
        ResponseEntity<String> response = restTemplate.exchange(outputUrl, POST, request, String.class);
        System.out.println("Response status: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody());
    }
}
