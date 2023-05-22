package pl.wlopata.sales;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ProductDetailProvider {
    private ArrayList<ProductDetails> productsList= new ArrayList<ProductDetails>();
    public Optional<ProductDetails> load(String productId) {
        return Optional.empty();
    }
}
