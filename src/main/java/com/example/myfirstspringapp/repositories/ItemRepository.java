package com.example.myfirstspringapp.repositories;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import com.example.myfirstspringapp.data.Category;
import com.example.myfirstspringapp.data.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
@Getter
public class ItemRepository {
    List<Item> items;
    List<Category> categories=new ArrayList<>();

    public ItemRepository(){
        System.out.println("constructor");
        String cat_name="dairy";
        categories.add(new Category(cat_name));
        categories.add(new Category("snacks"));

        items = new LinkedList<>();
        items.add(new Item("water",12.44f,categories.get(0)));
        items.add(new Item("protein bar",2.58f,categories.get(1)));
    }

    public Item getItem(int id){
        if(id>=items.size()) return null;
        return  items.get(id);
    }


    public Category getCategory(String name){
        return this.categories.stream().filter(category -> name.equals(category.getCat_name()))
                .findAny()
                .orElse(null);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(int id){
        this.items.remove(id);
    }



    public List<Item> getItemsFromCategory(String category){
        Predicate<Item> byCat = item -> item.getCategory().getCat_name().equals(category);

        var result = items.stream().filter(byCat)
                .collect(Collectors.toList());

        return result;
    }
}
