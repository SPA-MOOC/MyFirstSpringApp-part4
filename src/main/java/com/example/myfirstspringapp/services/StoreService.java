package com.example.myfirstspringapp.services;

import com.example.myfirstspringapp.data.Category;
import com.example.myfirstspringapp.data.Item;
import com.example.myfirstspringapp.repositories.Cart;
import com.example.myfirstspringapp.repositories.ItemRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@NoArgsConstructor
@Getter
public class StoreService {
    @Autowired
    ItemRepository items;
    @Autowired
    Cart cart;
    public List<Item> getItemsFromRepository() {return this.items.getItems();}
    public List<Item> getCartItems() {return cart.getItems();}
    public Item getItemFromRepository(int id){
        return  this.items.getItem(id);
    }
    public Category getCategoryFromRepository(String name){
        return this.items.getCategory(name);
    }
    public List<Item> getItemsFromCategory(String category){
        return this.items.getItemsFromCategory(category);
    }
    public void addItemToCart(int id){
        Item item=this.items.getItem(id);
        if(item!=null) this.cart.addItem(item);
    }
}
