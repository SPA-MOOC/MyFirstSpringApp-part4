package com.example.myfirstspringapp.controllers;

import com.example.myfirstspringapp.data.Item;
import com.example.myfirstspringapp.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    StoreService service;
    @GetMapping("/")
    public String getItemsInCart(Model model) {
        System.out.println("get cart in controller "+this.service.getItemsFromRepository());
        model.addAttribute("cart",this.service.getCartItems());
        model.addAttribute("prices",this.service.getCart().getPrices());
        return "cart";
    }
    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model) {
        this.service.addItemToCart(id);
        System.out.println("add item to cart in controller ");
        return "redirect:/cart/";
    }
}

