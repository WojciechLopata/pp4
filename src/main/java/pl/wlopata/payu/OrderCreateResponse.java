package pl.wlopata.payu;

public class OrderCreateResponse {
    String redirectUri;
    String orderId;

    public Object getRedirectUri() {
        return "uri";
    }

    public Object getOrderId() {
        return  "id";
    }
}
