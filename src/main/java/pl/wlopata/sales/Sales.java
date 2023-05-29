package pl.wlopata.sales;

import java.util.Optional;

public class Sales {
    private  ProductDetailProvider productDetailsProvider;
    private  CartStorage cartStorage;
    public  Sales (CartStorage cartStorage,ProductDetailProvider productDetailProvider,OfferMaker maker){
        this.cartStorage=cartStorage;
        this.productDetailsProvider=productDetailProvider;
    }
    void  addToCart(String customerId, String productId){
        Cart customersCart = loadForCustomer(customerId).orElse(Cart.empty());
        ProductDetails product= getProductDetails(productId).
                orElseThrow(()-> new NoSuchProductException());
        customersCart.add(product);
        CartStorage.save(customerId,customersCart);
    }
    private  Optional<ProductDetails> getProductDetails(String productId){
        return  productDetailsProvider.load(productId);
    }
    private Optional<Cart>  loadForCustomer(String customerId){
        return  cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String customer) {
        return new Offer();
    }
}
