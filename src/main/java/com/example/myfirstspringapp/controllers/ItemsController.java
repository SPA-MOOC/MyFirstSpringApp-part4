package com.example.myfirstspringapp.controllers;

import com.example.myfirstspringapp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemRepository items;

    @GetMapping("/")
    public String getItems(Model model) {
        System.out.println("get items in controller "+this.items);
        model.addAttribute("items",this.items.getItems());
        return "items";
    }
}
