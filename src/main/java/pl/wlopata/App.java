package pl.wlopata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.wlopata.creditcard.ProductCatalog.HashMapProductStorage;
import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
    @Bean
    ProductCatalog createProductCatalog(){
         ProductCatalog productCatalog= new ProductCatalog(new HashMapProductStorage());



        return productCatalog;
    }
}
