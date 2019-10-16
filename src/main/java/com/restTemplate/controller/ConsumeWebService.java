package com.restTemplate.controller;

import com.restTemplate.model.Food;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/restTemplate/")
public class ConsumeWebService {

    RestTemplate restTemplate;
    //Constructor injection
    public ConsumeWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("food")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/v1/food", HttpMethod.GET, entity, String.class).getBody();
    }

    @GetMapping("food/{id}")
    public Food getProductById (@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<Integer>(id, headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/" + id, HttpMethod.GET, entity, Food.class).getBody();
    }

    @PostMapping("food")
    public Food createProducts(@RequestBody Food food) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(food,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food", HttpMethod.POST, entity, Food.class).getBody();
    }

    @PutMapping("food")
    public Food updateProduct(@RequestBody Food product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food", HttpMethod.PUT, entity, Food.class).getBody();
    }

    @DeleteMapping("food/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<Integer>(id, headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
