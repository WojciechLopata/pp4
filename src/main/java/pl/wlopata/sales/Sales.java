package pl.wlopata.sales;

import pl.wlopata.sales.cart.Cart;
import pl.wlopata.sales.cart.CartStorage;
import pl.wlopata.sales.offering.Offer;
import pl.wlopata.sales.product.NoSuchProductException;
import pl.wlopata.sales.product.ProductCatalogProductDetailsProvider;
import pl.wlopata.sales.product.ProductDetails;

import java.util.Optional;

public class Sales {
    private ProductCatalogProductDetailsProvider productDetailsProvider;
    private CartStorage cartStorage;
    public  Sales (CartStorage cartStorage,ProductCatalogProductDetailsProvider productDetailProvider){
        this.cartStorage=cartStorage;
        this.productDetailsProvider=productDetailProvider;
    }
    void  addToCart(String customerId, String productId){
        Cart customersCart = loadForCustomer(customerId).orElse(Cart.empty());
        ProductDetails product= getProductDetails(productId).
                orElseThrow(()-> new NoSuchProductException());
        customersCart.add(product);
        cartStorage.save(customerId,customersCart);
    }
    private  Optional<ProductDetails> getProductDetails(String productId){
        return  productDetailsProvider.loadForProduct(productId);
    }
    private Optional<Cart>  loadForCustomer(String customerId){
        return  cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String customer) {
        return new Offer();

    }
    public  PaymentData acceptoffer(String customerId){
        Offer offer=getCurrentOffer(customerId);
    }
}
