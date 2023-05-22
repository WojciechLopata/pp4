package pl.wlopata.sales;

import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.creditcard.ProductCatalog.ProductStorage;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.UUID;

public class OfferMaker {
    public BigDecimal sumOfDiscounts=BigDecimal.valueOf(0);
    public void CheckForDiscounts(Cart customerCart,ProductCatalog catalog){
        if(FiftyForFiveHunderdDiscount(customerCart,catalog)) {
            sumOfDiscounts=sumOfDiscounts.add(BigDecimal.valueOf(50));

        }
        }


    private boolean FiftyForFiveHunderdDiscount(Cart customerCart, ProductCatalog catalog){
     BigDecimal total=  customerCart.totalPrice(catalog);
     if(total.compareTo((BigDecimal.valueOf(500)))==1){
        return true;
         }
     return false;
     }
     private int EverySameFifthItemFree(Cart customerCart, ProductCatalog catalog){
        BigDecimal sum= BigDecimal.valueOf(0);


        return sum.intValue();
     }




}
