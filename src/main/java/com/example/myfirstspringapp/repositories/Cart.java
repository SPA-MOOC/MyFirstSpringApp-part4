package pawww.example.store.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;
import pawww.example.store.data.Category;
import pawww.example.store.data.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@SessionScope
@Getter
@RequiredArgsConstructor
public class Cart {
    List<Item> items=new LinkedList<>();



    public Item getItem(int id){
        return  items.get(id);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(int id){
        this.items.remove(id);
    }


}
