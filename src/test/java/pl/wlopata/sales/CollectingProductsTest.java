package pl.wlopata.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private ProductDetailProvider productDetailProvider;

    @BeforeEach
    void setup(){
        cartStorage= new CartStorage();
        productDetailProvider = new ProductDetailProvider();
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
    void assertThereIsXProductsInCustomerCart(String customer, int productsCount){
        Cart customerCart= cartStorage.load(customer);
        assert  customerCart.itemsCount()== productsCount;

    }
    private String thereIsCustomer(String customerId){
        return  customerId;

    }
    private String thereIsProduct(){
        return UUID.randomUUID().toString();
    }
    private  Sales thereIsSalesModule(){
        return  new Sales();
    }

}
