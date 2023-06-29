package pl.wlopata.sales;

import org.junit.jupiter.api.Test;
import pl.wlopata.payu.Product;
import pl.wlopata.sales.offering.OfferAcceptanceRequest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OfferAcceptanceTest {
    @Test
    void itAllowsToAcceptOffer() {
        Sales sales = thereIsSalesModule();
        String product = thereIsExampleProduct("Konto", BigDecimal.valueOf(10.10),"EUW");
        String customerId = thereIsCustomer("XYZ");

        sales.addToCart(customerId, product);
        sales.addToCart(customerId, product);

        OfferAcceptanceRequest request = new OfferAcceptanceRequest();
        request
                .setFirstname("KTOŚ")
                .setLastname("ŚOTK")
                .setEmail("XYZ@example.com");

        ReservationDetails details = sales.acceptOffer(customerId, request);

        assertNotNull(details.getReservationId());
        assertNotNull(details.getPaymentUrl());
       /* assertPaymentGatewayWasInvoked();
        assertThereIsReservation(details.getReservationId());
        assertReservationIsPending(details.getReservationId());
        assertThereIsReservationForCustomer(details.getReservationId(), "XYZ@example.com");
        assertThereIsReservationForCustomerForTotal(details.getReservationId(), BigDecimal.valueOf(20.20));
        */
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private String thereIsExampleProduct(String name, BigDecimal price, String desc) {
        String id = UUID.randomUUID().toString();

        return id;
    }

    private Sales thereIsSalesModule() {
        return null;
    }
}
