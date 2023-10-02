package pl.wlopata.creditcard.ProductCatalog;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductStorage {
    Product loadById(String productId);

    List<Product> allPublishedProducts();

    List<Product> allProducts();

    void add(Product newProduct);

}
