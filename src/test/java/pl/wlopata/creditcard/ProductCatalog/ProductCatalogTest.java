package pl.wlopata.creditcard.ProductCatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.math.BigDecimal;


public  class  ProductCatalogTest{



    private void assertListIsEmpty(List<Product> products) {
        assert products.size()==0;
    }

    private ProductCatalog thereIsProductCatalog() {
        return  new ProductCatalog(new HashMapProductStorage());
    }
    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Konto 30lvl", "Eune",BigDecimal.valueOf(10));
        BigDecimal price=BigDecimal.valueOf((25));
        catalog.changePrice(productId,price);
    }


    @Test
    void ReadProductFromList(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Konto 30lvl", "Eune",BigDecimal.valueOf(10));
        assert  catalog.loadById(productId).getName()=="Konto 30lvl";


    }
    @Test
    void itDoNotAllowsToAddProductWithoutName(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Konto 30lvl", "Eune",BigDecimal.valueOf(10));

    }
    @Test
    void itDoesNotShowDraftProducts(){
        ProductCatalog catalog=thereIsProductCatalog();
        String productId= catalog.addProduct("nazwa","opis",BigDecimal.valueOf(10));

        //Assert
        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertEquals(0, publishedProducts.size());
    }

    @Test
    void  itAllowstoPublishProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId=catalog.addProduct("abcd","Alfabet", BigDecimal.valueOf(30));
        catalog.changePrice(productId,BigDecimal.valueOf(10));
        catalog.assignImage(productId,"Nice.jpeg");
        catalog.publishProduct(productId);
        List<Product> publishedProducts=catalog.allPublishedProducts();


    }
    @Test
    void draftProductsAreNotListedForBeingSold() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Klucz csgo", "Do skrzyni breakout",BigDecimal.valueOf(12.5));

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertEquals(0, publishedProducts.size());
    }

}