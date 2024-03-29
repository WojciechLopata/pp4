package pl.wlopata.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wlopata.sales.offering.Offer;

@RestController
public class SalesController {
    Sales sales;
    public SalesController(Sales sales){
        this.sales=sales;
    }
    @GetMapping("/api/get-current-offer")
    public Offer getCurrentOffer(){

        return sales.getCurrentOffer(getCurrentCustomer());


    }
    @PostMapping("api/add-to-cart/{productId}")
    public void AddToCart(@PathVariable String productId){
        System.out.println("ma się nie wyświetlać");
        sales.addToCart(getCurrentCustomer(),productId);

    }
    private String getCurrentCustomer() {
        return "Shrek";
    }


}

