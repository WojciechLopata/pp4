package pl.wlopata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.wlopata.creditcard.ProductCatalog.HashMapProductStorage;
import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.sales.*;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
    @Bean
    ProductCatalog createProductCatalog(){
         ProductCatalog productCatalog= new ProductCatalog(new HashMapProductStorage());
         String product1= productCatalog.addProduct("konto","eune",BigDecimal.valueOf(30));
         productCatalog.assignImage(product1,"Image");
         productCatalog.changePrice(product1,BigDecimal.valueOf(10));
         productCatalog.publishProduct(product1);
         String product2= productCatalog.addProduct("konto","euw",BigDecimal.valueOf(30));
         productCatalog.assignImage(product2,"Image");
         productCatalog.changePrice(product2,BigDecimal.valueOf(15));
         productCatalog.publishProduct(product2);




        return productCatalog;
    }
    @Bean
    Sales createSales () {

        return  new Sales(new CartStorage(), new ProductDetailProvider(), new OfferMaker());
    }
}
