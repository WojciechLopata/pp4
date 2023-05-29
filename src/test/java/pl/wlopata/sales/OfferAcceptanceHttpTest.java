package pl.wlopata.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfferAcceptanceTest {
    @Autowired
    ProductCatalog productCatalog;
    @Autowired
    TestRestTemplate http;
    @Test
    void itAllowsToAcceptOffer(){
        String productId=thereisExampleProduct();
        http.postForEntity(String.format("/api/add-to-cart/%s",productId),null,String.class);
    }

    private String thereisExampleProduct() {
        return productCatalog.allPublishedProducts()
    }
}
