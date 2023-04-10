package pawww.example.store.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawww.example.store.controllers.DataNotFoundException;
import pawww.example.store.data.Category;
import pawww.example.store.data.Item;
import pawww.example.store.repositories.Cart;
import pawww.example.store.repositories.ItemRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@Getter
public class StoreService {
    @Autowired
    ItemRepository items;
    @Autowired
    Cart cart;



    public void addToCart(Item item){
        this.cart.addItem(item);
    }


    public Item getItem(int id){
        return  items.getItem(id);
    }


    public Category getCategory(String name){
        return this.items.getCategory(name);
    }

    public void addItem(Item item){
        this.items.addItem(item);
    }

    public void removeItem(int id){
        this.items.removeItem(id);
    }



    public List<Item> getItemsFromCategory(String category){
        return items.getItemsFromCategory(category);
    }
}
