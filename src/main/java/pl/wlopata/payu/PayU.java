package pl.wlopata.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PayU {
    RestTemplate http;
    private final PayUApiCredentials config;
    public  PayU(PayUApiCredentials config,RestTemplate http){
        this.http=http;
        this.config=config;
    }
    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        String url ="https://secure.payu.com/api/v2_1/orders";
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-type","application/json");
        headers.add("Authorization", String.format("Bearer %s", getToken()));
        HttpEntity<OrderCreateRequest>  request = new HttpEntity<>(orderCreateRequest,headers);
        ResponseEntity<OrderCreateResponse> response = http.postForEntity(url, request, OrderCreateResponse.class);
        return response.getBody();
    }

    private Object getToken() {
        return "3e5cac39-7e38-4139-8fd6-30adc06a61bd";
    }
}
