package pl.wlopata.sales.product;

import java.util.Optional;

public class AlwaysMissingProductDetailProvider implements ProductDetailsProvider {

    @Override
    public Optional<ProductDetails> loadForProduct(String productid) {
        return Optional.empty();
    }
}
