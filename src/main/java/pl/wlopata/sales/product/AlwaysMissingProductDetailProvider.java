package pl.wlopata.sales;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class AlwaysMissingProductDetailProvider implements ProductDetailsProvider {

    @Override
    public Optional<ProductDetails> loadForProduct(String productid) {
        return Optional.empty();
    }
}
