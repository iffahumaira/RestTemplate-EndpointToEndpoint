package com.restTemplate.restTemplate.controller;

import com.restTemplate.restTemplate.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/v1/food/findAll", HttpMethod.GET, entity, String.class).getBody();
    }

    //NOT GET YET!!
    @RequestMapping(value = "/template/findById", method = RequestMethod.POST)
    public Food getProductById (@RequestBody Food food) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(food, headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/findById", HttpMethod.POST, entity, Food.class).getBody();
    }

    @RequestMapping(value = "/template/add", method = RequestMethod.POST)
    public Food createProducts(@RequestBody Food food) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(food,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/addMenu", HttpMethod.POST, entity, Food.class).getBody();
    }

    @RequestMapping(value = "/template/update", method = RequestMethod.PUT)
    public Food updateProduct(@RequestBody Food product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/updateById", HttpMethod.PUT, entity, Food.class).getBody();
    }

    @RequestMapping(value = "/template/delete", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestBody Food food) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<Integer>(food.getId(), headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/deleteById", HttpMethod.DELETE, entity, String.class).getBody();
    }
}
