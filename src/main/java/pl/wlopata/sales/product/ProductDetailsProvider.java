package pl.wlopata.sales.product;

import java.util.Optional;

public interface ProductDetailsProvider {

    Optional<ProductDetails> loadForProduct(String productid);
}
