package com.restTemplate.restTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private int id;
    private String menu;
    private String description;
    private int quantity;
    private double price;

}
