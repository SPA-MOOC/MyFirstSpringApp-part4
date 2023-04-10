package com.example.myfirstspringapp.repositories;

import com.example.myfirstspringapp.data.Item;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedList;
import java.util.List;

@Component
@Getter
@SessionScope
public class Cart {
    List<Item> items=new LinkedList<>();
    public Item getItem(int nr){
        return  items.get(nr);
    }
    public void addItem(Item item){
        this.items.add(item);
    }
}
