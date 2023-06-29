package pl.wlopata.creditcard.ProductCatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductCatalogController {
    private  ProductCatalog catalog;
    ProductCatalogController(ProductCatalog catalog){
        this.catalog=catalog;
    }
    @GetMapping("/api/products")
    public List<Product> allproducts(){

        return catalog.allPublishedProducts();
    }
}
