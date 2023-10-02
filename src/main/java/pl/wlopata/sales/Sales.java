package pl.wlopata.sales;

import org.hibernate.annotations.Fetch;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.wlopata.creditcard.ProductCatalog.HashMapProductStorage;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalogController;
import pl.wlopata.creditcard.ProductCatalog.ProductStorage;
import pl.wlopata.payu.Buyer;
import pl.wlopata.payu.OrderCreateRequest;
import pl.wlopata.payu.PayU;
import pl.wlopata.payu.Product;
import pl.wlopata.sales.cart.Cart;
import pl.wlopata.sales.cart.CartStorage;
import pl.wlopata.sales.offering.Offer;
import pl.wlopata.sales.offering.OfferAcceptanceRequest;
import pl.wlopata.sales.offering.OfferMaker;
import pl.wlopata.sales.product.NoSuchProductException;
import pl.wlopata.sales.product.ProductCatalogProductDetailsProvider;
import pl.wlopata.sales.product.ProductDetails;
import pl.wlopata.sales.product.ProductDetailsProvider;
import pl.wlopata.sales.reservation.Reservation;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public Offer getCurrentOffer(String customer) throws IOException, ParseException {
        Cart customerCart = loadForCustomer(customer).orElse(Cart.empty());
        ProductCatalog catalog = HashMapProductStorage.loadFromJson();
        BigDecimal price= customerCart.totalPrice(catalog);
        System.out.println("Cena to "+price.intValue());
        BigDecimal discount = new OfferMaker().CheckForDiscounts(customerCart,catalog);
        System.out.println("rabat to "+discount.intValue());
        price=price.subtract(discount);








        Offer offer = new Offer(price,customerCart.itemsCount());
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

