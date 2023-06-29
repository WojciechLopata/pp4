package pl.wlopata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.wlopata.creditcard.ProductCatalog.HashMapProductStorage;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.payu.PayU;
import pl.wlopata.payu.PayUApiCredentials;
import pl.wlopata.payu.PayuPaymentGateway;
import pl.wlopata.sales.*;
import pl.wlopata.sales.cart.CartStorage;
import pl.wlopata.sales.product.ProductCatalogProductDetailsProvider;

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
    PaymentGateway createPaymentGateway() {
        return new PayuPaymentGateway(new PayU(PayUApiCredentials.sandbox(), new RestTemplate()));
    }

    @Bean
    Sales createSales (ProductCatalog catalog,PaymentGateway paymentGateway) {

        return  new Sales(new CartStorage(), new ProductCatalogProductDetailsProvider(catalog),paymentGateway);
    }


//TODO Potwierdzanie konta i TOKEN "ressetting passowrd token" i perawdzimy random
}
