package pl.wlopata.sales;

import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class Cart {
    private ArrayList<UUID> productList= new ArrayList<UUID>();
//    private Map<UUID,int> productMap= new TreeMap<>();

    public ArrayList<UUID> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<UUID> productList) {
        this.productList = productList;
    }

    public  static  Cart empty(){
        return  new Cart();

    }

    public int itemsCount() {
        return  0;
    }
    public BigDecimal totalPrice(ProductCatalog catalog){
        BigDecimal sum=BigDecimal.valueOf(0);
        for (UUID productID: productList) {
            Product product= catalog.loadById(productID.toString());
            BigDecimal price= product.getPrice();
            sum.add(price);


            
        }
        return  sum;
    }

    public void add(ProductDetails product) {




    }
    public void groupItems(){

    }
}
