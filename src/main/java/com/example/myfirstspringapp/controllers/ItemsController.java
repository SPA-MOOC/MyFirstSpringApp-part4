package com.example.myfirstspringapp.controllers;

import com.example.myfirstspringapp.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    StoreService service;

    @GetMapping("/")
    public String getItems(Model model) {
        System.out.println("get items in controller "+this.service.getItemsFromRepository());
        model.addAttribute("items",this.service.getItemsFromRepository());
        return "items";
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable("id") int id, Model model) {
        System.out.println("get one item in controller "+id+" "+this.service.getItemFromRepository(id));
        model.addAttribute("index",id);
        model.addAttribute("item",this.service.getItemFromRepository(id));
        return "item";
    }

    @GetMapping("/category")
    public String getItems(@RequestParam("name") String category, Model model) {
        System.out.println("get items from category "+category+" in controller "+this.service.getItemsFromCategory(category));
        model.addAttribute("items",this.service.getItemsFromCategory(category));
        model.addAttribute("category",category);
        return "items";
    }
}
