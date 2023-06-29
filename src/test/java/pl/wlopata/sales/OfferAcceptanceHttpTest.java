package pl.wlopata.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import org.springframework.http.HttpStatus;
import pl.wlopata.sales.offering.OfferAcceptanceRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfferAcceptanceHttpTest {
    @Autowired
    ProductCatalog productCatalog;
    @Autowired
    TestRestTemplate http;

    void itAllowsToAcceptOffer(){
        String productId=thereisExampleProduct();
        OfferAcceptanceRequest acceptOffer= new  AcceptOffer("ANON","Imowy@gmail.com");
        http.postForEntity(String.format("/api/add-to-cart/%s",productId),null,String.class);
        http.postForEntity(String.format("/api/add-to-cart/%s",productId),null,String.class);
        ResponseEntity<PaymentData> response =  http.postForEntity(String.format("/api/accept-offer"),null,PaymentData.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);

    }



    private String thereisExampleProduct() {
        return productCatalog.allPublishedProducts().toString();
    }

}
