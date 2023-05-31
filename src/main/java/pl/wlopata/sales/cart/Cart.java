package pl.wlopata.sales.cart;

import pl.wlopata.creditcard.ProductCatalog.Product;
import pl.wlopata.creditcard.ProductCatalog.ProductCatalog;
import pl.wlopata.sales.product.ProductDetails;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {
    private ArrayList<String> productList= new ArrayList<String>();
//    private Map<UUID,int> productMap= new TreeMap<>();

    public ArrayList<String> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<String > productList) {
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
        for (String productID: productList) {
            Product product= catalog.loadById(productID.toString());
            BigDecimal price= product.getPrice();
            sum.add(price);


            
        }
        return  sum;
    }

    public void add(ProductDetails product) {
        productList.add(product.getId());




    }
    public void groupItems(){


    }
}
