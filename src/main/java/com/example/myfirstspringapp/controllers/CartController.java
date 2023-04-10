package pawww.example.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pawww.example.store.data.Item;
import pawww.example.store.repositories.ItemRepository;
import pawww.example.store.services.StoreService;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

//   @Autowired
//   ItemRepository cart;

    //(3)
    @Autowired
    StoreService service;


    @GetMapping("/")
    public String getItems(Model model) {
        System.out.println("get cart in controller "+this.service.getCart().getItems());
        model.addAttribute("cart",this.service.getCart().getItems());
        return "cart";
    }


    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model)  /* 1,2, 3 */throws Exception {
        //1 - w. og.
        //try{
        Item item2add=service.getItems().getItem(id);
            // 3 - własna klasa wyjątku
            if(item2add==null) throw new DataNotFoundException(String.valueOf(id));
            // 1,2 - wyjątek ogólny
            //if(item2add==null) throw new Exception();

            this.service.getCart().addItem(item2add);
            System.out.println("add item to cart in controller " + item2add);
            model.addAttribute("cart", this.service.getCart().getItems());
            return "redirect:/cart/";
            // 1 - wyjątek ogólny z obsługą w metodzie kontrolera
//        }catch (Exception e){
//            System.out.println("error "+e.getMessage());
//            model.addAttribute("errorMsg",e.getMessage());
//            return "error";
//        }
    }

// 2,3 - wyjątek ogólny dla wszystkich
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No requested data")
    public void handleDataError() {
        System.out.println("ERROR");
    }

    //3 - własna klasa wyjątku
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data with requested id")
    public String handleDataError(DataNotFoundException e) {
        System.out.println("ERROR "+e.getMessage() );
        return "error";
    }
}

