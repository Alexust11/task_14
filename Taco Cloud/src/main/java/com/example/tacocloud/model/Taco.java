package com.example.tacocloud.model;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<Indgridient> ingredients;
}
