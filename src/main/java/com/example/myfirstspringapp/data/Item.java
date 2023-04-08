package com.example.myfirstspringapp.data;

import lombok.Data;


@Data
public class Item {
    private final String name;
    private final float price;
    private final Category category;
}
