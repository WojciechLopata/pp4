package pl.wlopata.sales.cart;

import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.sales.offering.OfferMaker;
import pl.wlopata.sales.product.ProductDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<String> products;

    public List<String> getProducts() {
        return products;
    }

    public Cart setProducts(List<String> products) {
        this.products = products;
        return this;
    }

    public Cart() {
        this.products = new ArrayList<>();
    }

    public  static  Cart empty(){
        return  new Cart();

    }

    public int itemsCount() {
        return products.size();
    }
    public BigDecimal totalPrice(ProductCatalog catalog){

        BigDecimal sum=BigDecimal.valueOf(0);
        for (String productID: products) {
            System.out.println(products);
            Product product= catalog.loadById(productID.toString());
            BigDecimal price= product.getPrice();

            sum = sum.add(price);



            System.out.println(sum);
        }

        return  sum;
    }

    public void add(ProductDetails product) {
        System.out.println(product.getId());
        products.add(product.getId());




    }
    public void groupItems(){


    }
}
