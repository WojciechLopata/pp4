package pl.wlopata.creditcard.ProductCatalog;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {
    private ProductStorage productStorage;
    private  BigDecimal price;
    public ProductCatalog(ProductStorage productStorage){
        this.productStorage=productStorage;
    }
    public void publishProduct(String productId) {
        Product product = loadById(productId);

        if (product.getImage() == null) {
            throw new ProductCantBePublishedException();
        }

        if (product.getPrice() == null) {
            throw new ProductCantBePublishedException();
        }

        product.setOnline(true);
    }

    public List<Product> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }


    public  String addProduct(String name, String desc,BigDecimal price){
        Product newOne=new Product(UUID.randomUUID(),name,desc,price);
        productStorage.add(newOne);
        return  ((Product) newOne).getId();
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        Product product=loadById(productId);
        product.changePrice(newPrice);
    }
    public Product loadById(String productId) {
        return productStorage.loadById(productId);
    }
    public void assignImage(String productId, String imageKey) {
        Product product = loadById(productId);

        product.setImage(imageKey);

    }
}
