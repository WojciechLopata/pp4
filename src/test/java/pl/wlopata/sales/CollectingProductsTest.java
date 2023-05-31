package pl.wlopata.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wlopata.sales.cart.Cart;
import pl.wlopata.sales.cart.CartStorage;
import pl.wlopata.sales.offering.OfferMaker;
import pl.wlopata.sales.product.ProductCatalogProductDetailsProvider;

import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private ProductCatalogProductDetailsProvider productDetailProvider;
    private OfferMaker offerMaker;

    @BeforeEach
    void setup(){
        cartStorage= new CartStorage();
        productDetailProvider = new ProductDetailProvider();
        offerMaker = new OfferMaker();
    }

    @Test
    void itAllowsToCollectProductsToCart(){
        //arrange
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customer = thereIsCustomer("Kuba");

        //act
        sales.addToCart(customer,productId);
        assertThereIsXProductsInCustomerCart(customer,1);

    }
    @Test
    void assertThereIsXProductsInCustomerCart(String customer, int productsCount){
        Cart customerCart = cartStorage.load(customer).get();
        assert customerCart.itemsCount() == productsCount;
      //  Cart customerCart= cartStorage.load(customer);
    //    assert  customerCart.itemsCount()== productsCount;

    }
    @Test
    private String thereIsCustomer(String customerId){
        return  customerId;

    }
    @Test
    private String thereIsProduct(){
        return UUID.randomUUID().toString();
    }
    @Test
    private  Sales thereIsSalesModule(){
        return  new Sales(cartStorage,productDetailProvider,offerMaker);
    }

}
