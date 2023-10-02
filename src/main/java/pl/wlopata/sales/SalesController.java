package pl.wlopata.sales;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wlopata.sales.offering.Offer;

import java.io.IOException;

@RestController
public class SalesController {
    Sales sales;
    public SalesController(Sales sales){
        this.sales=sales;
    }
    @GetMapping("/api/get-current-offer")
    public Offer getCurrentOffer() throws IOException, ParseException {

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

