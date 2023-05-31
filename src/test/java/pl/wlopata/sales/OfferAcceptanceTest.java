package pl.wlopata.sales;

import org.junit.jupiter.api.Test;

public class OfferAcceptanceTest {
    @Test
    void itAllowsToAcceptOffer(){

        Sales sales = thereIsSalesModule();
        String productId=thereIsExampleProduct();
        String customerID=thereIsCustorem();
        sales.addToCart(customerID,productId);
        sales.addToCart(customerID,productId);
        PaymentData paymentData= sales.acceptOffer(customerID);
        assertCustomerHasNReservation(customerID,1);
        assertNotNull(paymentData.getPaymentUrl());
    }
}
