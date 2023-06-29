package pl.wlopata.sales;

import org.hibernate.annotations.Fetch;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalogController;
import pl.wlopata.payu.Buyer;
import pl.wlopata.payu.OrderCreateRequest;
import pl.wlopata.payu.PayU;
import pl.wlopata.payu.Product;
import pl.wlopata.sales.cart.Cart;
import pl.wlopata.sales.cart.CartStorage;
import pl.wlopata.sales.offering.Offer;
import pl.wlopata.sales.offering.OfferAcceptanceRequest;
import pl.wlopata.sales.product.NoSuchProductException;
import pl.wlopata.sales.product.ProductCatalogProductDetailsProvider;
import pl.wlopata.sales.product.ProductDetails;
import pl.wlopata.sales.product.ProductDetailsProvider;
import pl.wlopata.sales.reservation.Reservation;


import java.math.BigDecimal;
import java.util.Optional;

public class Sales {
    private ProductDetailsProvider productDetailsProvider;
    private CartStorage cartStorage;
    private PaymentGateway paymentGateway;
    public  Sales (CartStorage cartStorage, ProductDetailsProvider productDetailProvider, PaymentGateway paymentGateway){
        this.cartStorage=cartStorage;
        this.productDetailsProvider=productDetailProvider;
    }
    void  addToCart(String customerId, String productId){
        System.out.println(customerId);
        Cart customersCart = loadForCustomer(customerId).orElse(Cart.empty());
        ProductDetails product= getProductDetails(productId).
                orElseThrow(()-> new NoSuchProductException());
        System.out.println(product.getName());
        customersCart.add(product);

        cartStorage.save(customerId,customersCart);
    }
    private  Optional<ProductDetails> getProductDetails(String productId){
        return  productDetailsProvider.loadForProduct(productId);
    }
    private Optional<Cart> loadForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String customer) {
        Cart customerCart = loadForCustomer(customer).orElse(Cart.empty());
        //TODO DODAĆ JAKOŚ BRANIE PRODUCTCATALOGU I WSADZENIE DO OFFERTY


        Offer offer = new Offer(BigDecimal.valueOf(10),customerCart.itemsCount());
        return  offer;

    }
    public ReservationDetails acceptOffer(String customerId, OfferAcceptanceRequest request) {
        return  null;

        /*
        Offer offer = this.getCurrentOffer(customerId);

        PaymentData payment = paymentGateway.register(RegisterPaymentRequest.of(request, offer));

        Reservation reservation = Reservation.of(request, offer, payment);

        reservationStorage.save(reservation);

        return new ReservationDetails(reservation.getId(), reservation.getPaymentUrl());
    */
    }




}

