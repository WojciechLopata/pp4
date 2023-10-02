package pl.wlopata.sales.offering;

import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.sales.cart.Cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OfferMaker {

    public BigDecimal CheckForDiscounts(Cart customerCart, ProductCatalog catalog){
        int sumOfDiscounts=0;
        if(FiftyForFiveHunderdDiscount(customerCart,catalog)) {
            sumOfDiscounts=sumOfDiscounts+50;

        }
        sumOfDiscounts=sumOfDiscounts+EverySameFifthItemFree(customerCart,catalog);
        return BigDecimal.valueOf(sumOfDiscounts);

        }


    private boolean FiftyForFiveHunderdDiscount(Cart customerCart, ProductCatalog catalog){
     BigDecimal total=  customerCart.totalPrice(catalog);
     if(total.compareTo((BigDecimal.valueOf(500)))==1){
        return true;
         }
     return false;
     }
     private int EverySameFifthItemFree(Cart customerCart, ProductCatalog catalog){

        List<String> products= customerCart.getProducts().stream().distinct().collect(Collectors.toList());
        Map<String,Long> productCount= customerCart.getProducts().stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(productCount);

        int sum=0;
        for (String product:products){

            sum=sum+ productCount.get(product).intValue()/5*catalog.loadById(product).getPrice().intValue();




         }
        System.out.println(sum);





        return sum;
     }




}
