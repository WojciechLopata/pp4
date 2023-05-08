package pl.wlopata.sales;

import java.util.Optional;

public interface CartStorage {
    public Optional<Cart> load(String customerId){
        return  Optional.empty();
    }
}
