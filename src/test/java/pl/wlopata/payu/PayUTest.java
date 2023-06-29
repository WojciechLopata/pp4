package pl.wlopata.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayUTest {
    @Test
    void itRegisterPayment(){
        PayU payu=thereIsPayU();
        OrderCreateRequest request = thereIsExampleOrderCreateRequest();
        OrderCreateResponse response= payu.handle(request);
        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());

    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        OrderCreateRequest exampleRequest=new OrderCreateRequest();
        exampleRequest.setNotifyUrl("https://your.eshop.com/notify");
        exampleRequest.setMerchantPosId("145227");
        exampleRequest.setDescription("RTV market");
        exampleRequest.setCurrencyCode("PLN");
        exampleRequest.setTotalAmount(3000000);
        exampleRequest.setBuyer((new Buyer().setEmail("fajnymail@hotmail.com").setFirstName("Shrek").setLastName("z bagien"))
                .setPhone("1234556789").setLanguage("pl"));
        exampleRequest.setProducts(Arrays.asList(
                new Product().setName("Konto").setQuantity(3).setUnitPrice(1000000)
        ));
        return  exampleRequest;
    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate());
    }
}
