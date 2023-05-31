package pl.wlopata.sales.cart;

import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    HashMap<String, Cart > carts;
    public CartStorage(){
        this.carts=new HashMap<>();
    }


    public  void save(String customerId, Cart customersCart) {
        carts.put(customerId,customersCart);

    }

    public Optional<Cart> load(String customerId) {
        return Optional.of(carts.get(customerId));}
}
