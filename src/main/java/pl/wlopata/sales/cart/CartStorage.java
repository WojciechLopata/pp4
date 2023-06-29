package pl.wlopata.sales.cart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    HashMap<String, Cart> carts;

    public CartStorage() {
        this.carts = new HashMap<>();
    }

    public Optional<Cart> load(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void save(String customerId, Cart customersCart) {
        carts.put(customerId, customersCart);
        System.out.println(Arrays.asList(carts));
        customersCart.products.forEach(System.out::println);
    }
}