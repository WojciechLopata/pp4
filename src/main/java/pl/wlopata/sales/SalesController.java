package pl.wlopata.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    Sales sales;
    public SalesController(Sales sales){
        this.sales=sales;
    }
  /*  @GetMapping("/api/get-current-offer")
    public  Offer getCurrentOffer(){
        return sales.getCurrentOffer();


    }
    @PostMapping('/api/add-to-cart/{productId}')
    public  void AddToCard(@PathVariable String productId){
        sales.addToCart(getCurrentCustomer(),productId);

    }
    private  String getCurrentOffer
*/
}

