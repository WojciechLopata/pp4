package pl.wlopata.creditcard.ProductCatalog;

import java.util.List;

public class ListProductStorage implements ProductStorage{
    List<Product> products;

    public ListProductStorage(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> allProducts(){
        return products;
    }
    @Override
    public Product loadById(String productId) {
        return  null;
       // return; products.stream().filter(product -> product.getId().equals(productId).findFirst();
    }

    @Override
    public List<Product> allPublishedProducts() {
        return null;
    }


    @Override
    public void add(Product newProduct) {
        //TODO to coś
        //products.add(newProduct.getId(), newProduct);
    }
}