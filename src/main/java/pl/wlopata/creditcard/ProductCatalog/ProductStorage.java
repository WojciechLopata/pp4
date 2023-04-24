package pl.wlopata.creditcard.ProductCatalog;

import java.util.List;

public interface ProductStorage {
    Product loadById(String productId);

    List<Product> allPublishedProducts();

    List<Product> allProducts();

    void add(Product newProduct);
}
