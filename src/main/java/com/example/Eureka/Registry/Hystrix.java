package com.example.Eureka.Registry;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class Hystrix
{
    private final RestTemplate restTemplate;


    public Hystrix(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String allUsers() {
        URI uri = URI.create("http://localhost:8080/");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Nagendra";
    }

}
